package exercise;

/**
 * Enum to define what options we have to run LoadHandlerTask
 *
 * @author Pezhman Jahanmard
 */
public enum LoadHandlerMode {
	/**
	 * updates for all companies must be sent, so every second we cut N updates (MAX_PRICE_UPDATES) from the beginning of the list.
	 */
	SEND_ALL_COMPANIES_UPDATES,
	/**
	 * we only send updates for last N companies (MAX_PRICE_UPDATES) per second and cache will be cleared out every second.
	 */
	DROP_EXCEEDED_COMPANIES
}
