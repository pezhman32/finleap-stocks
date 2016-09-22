package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class LoadHandler {
	
	private static final int MAX_PRICE_UPDATES = 100;
	private final Consumer consumer;
	private List<PriceUpdate> priceUpdateList;
	private LoadHandlerTask loadHandlerTask;
	
	public LoadHandler (Consumer consumer) {
		this.consumer = consumer;
		priceUpdateList = new ArrayList<>();

		//initialize loadHandlerTask and call it every 1 second, starting from 1 second later
		loadHandlerTask = new LoadHandlerTask(MAX_PRICE_UPDATES, this.consumer, priceUpdateList);
		Timer timer = new Timer();
		timer.schedule(loadHandlerTask, 1000, 1000);
	}
	
	public void receive(PriceUpdate priceUpdate) {
		int indexOfFoundPrice = priceUpdateList.indexOf(priceUpdate);
		if (indexOfFoundPrice == -1) {
			//if not found in list, then add new one
			priceUpdateList.add(priceUpdate);
		} else {
			//if already found, then replace with old index but new price!
			priceUpdateList.set(indexOfFoundPrice, priceUpdate);
		}
	}
	
}
