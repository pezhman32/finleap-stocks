package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Timer to control serve consumer fixed amount of data per second.
 *
 * @author Pezhman Jahanmard
 */
public class LoadHandlerTask extends TimerTask {
	/**
	 * Since I did not figured out what's the exact logic asked in specs, I've implemented the feature in two ways:
	 *
	 * 1: updates for all companies must be sent, so every second we cut N updates (MAX_PRICE_UPDATES) from the beginning of the list.
	 * 2: we only send updates for last N companies (MAX_PRICE_UPDATES) per second and cache will be cleared out every second.
	 */
	private final static LoadHandlerMode TASK_OPTION = LoadHandlerMode.SEND_ALL_COMPANIES_UPDATES;
	private final int maxPriceUpdates;
	private final Consumer consumer;
	private List<PriceUpdate> priceUpdateList;

	/**
	 *
	 * @param maxPriceUpdates number of max updates to send each time this task is going to run
	 * @param consumer Consumer to send updates to
	 * @param priceUpdateList list of price updates, consider that list content will be updated by this Task
	 */
	public LoadHandlerTask(int maxPriceUpdates, Consumer consumer, List<PriceUpdate> priceUpdateList) {
		this.maxPriceUpdates = maxPriceUpdates;
		this.consumer = consumer;
		this.priceUpdateList = priceUpdateList;
	}

	@Override
	public void run() {
		if (LoadHandlerMode.SEND_ALL_COMPANIES_UPDATES.equals(TASK_OPTION)) {
			runWithoutMissingAnyUpdate();
		} else if (LoadHandlerMode.DROP_EXCEEDED_COMPANIES.equals(TASK_OPTION)) {
			runWithDroppingOlderUpdates();
		}
	}

	/**
	 * Option2: all updates must be sent, so every second we cut N updates (MAX_PRICE_UPDATES) from the beginning of the list.
	 */
	private void runWithoutMissingAnyUpdate() {
		//cut sub list of priceUpdateList (with given size) from the beginning of the array and send it to consumer at once
		ArrayList<PriceUpdate> range = new ArrayList<>();
		int size = priceUpdateList.size();
		for (int i = 0; i < maxPriceUpdates && i < size; i++) {
			range.add(priceUpdateList.get(0));
			priceUpdateList.remove(0);
		}

		if (range.size() > 0) {
			consumer.send(range);
		}
	}

	/**
	 * Option1: we only send last N updates (MAX_PRICE_UPDATES) per second and cache will be cleared out every second.
	 * Sent price would be most recent updates
	 */
	private void runWithDroppingOlderUpdates() {
		//cut sub list of priceUpdateList (with given size) from the end of the array and send it to consumer at once
		int startIndex = priceUpdateList.size() - maxPriceUpdates;
		if (startIndex < 0) {
			startIndex = 0;
		}

		ArrayList<PriceUpdate> range = new ArrayList<>();
		for (int i = startIndex; i < priceUpdateList.size(); i++) {
			range.add(priceUpdateList.get(i));
		}

		priceUpdateList.clear();
		if (range.size() > 0) {
			consumer.send(range);
		}
	}
}
