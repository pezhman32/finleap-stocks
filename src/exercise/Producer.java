package exercise;

public class Producer extends Thread {
	
	private LoadHandler loadHandler;
	
	public Producer(LoadHandler loadHandler) {
		this.loadHandler = loadHandler;
	}
	
	@Override
	public void run() {
		generateUpdates();
	}
	
	public void generateUpdates(){
		for (int i = 1; i < 1000000; i++) {
			loadHandler.receive(new PriceUpdate("Apple", 97.85));
			loadHandler.receive(new PriceUpdate("Google", 160.71));
			loadHandler.receive(new PriceUpdate("Facebook", 91.66));
			loadHandler.receive(new PriceUpdate("Google", 160.73));
			loadHandler.receive(new PriceUpdate("Facebook", 91.71));
			loadHandler.receive(new PriceUpdate("Google", 160.76));
			loadHandler.receive(new PriceUpdate("Apple", 97.85));
			loadHandler.receive(new PriceUpdate("Google", 160.71));
			loadHandler.receive(new PriceUpdate("Facebook", 91.63));
			loadHandler.receive(new PriceUpdate("2nd-Apple", 95.85));
			loadHandler.receive(new PriceUpdate("2nd-Google", 150.71));
			loadHandler.receive(new PriceUpdate("2nd-Facebook", 95.66));
			loadHandler.receive(new PriceUpdate("2nd-Google", 150.73));
			loadHandler.receive(new PriceUpdate("2nd-Facebook", 95.71));
			loadHandler.receive(new PriceUpdate("2nd-Google", 150.76));
			loadHandler.receive(new PriceUpdate("2nd-Apple", 95.85));
			loadHandler.receive(new PriceUpdate("2nd-Google", 150.71));
			loadHandler.receive(new PriceUpdate("2nd-Facebook", 95.63));
			loadHandler.receive(new PriceUpdate("3rd-Apple", 96.85));
			loadHandler.receive(new PriceUpdate("3rd-Google", 160.71));
			loadHandler.receive(new PriceUpdate("3rd-Facebook", 96.66));
			loadHandler.receive(new PriceUpdate("3rd-Google", 160.73));
			loadHandler.receive(new PriceUpdate("3rd-Facebook", 96.71));
			loadHandler.receive(new PriceUpdate("3rd-Google", 160.76));
			loadHandler.receive(new PriceUpdate("3rd-Apple", 96.85));
			loadHandler.receive(new PriceUpdate("3rd-Google", 160.71));
			loadHandler.receive(new PriceUpdate("3rd-Facebook", 96.63));
			loadHandler.receive(new PriceUpdate("4th-Apple", 97.85));
			loadHandler.receive(new PriceUpdate("4th-Google", 170.71));
			loadHandler.receive(new PriceUpdate("4th-Facebook", 97.66));
			loadHandler.receive(new PriceUpdate("4th-Google", 170.73));
			loadHandler.receive(new PriceUpdate("4th-Facebook", 97.71));
			loadHandler.receive(new PriceUpdate("4th-Google", 170.76));
			loadHandler.receive(new PriceUpdate("4th-Apple", 97.85));
			loadHandler.receive(new PriceUpdate("4th-Google", 170.71));
			loadHandler.receive(new PriceUpdate("4th-Facebook", 97.63));
			loadHandler.receive(new PriceUpdate("5th-Apple", 98.85));
			loadHandler.receive(new PriceUpdate("5th-Google", 180.71));
			loadHandler.receive(new PriceUpdate("5th-Facebook", 98.66));
			loadHandler.receive(new PriceUpdate("5th-Google", 180.73));
			loadHandler.receive(new PriceUpdate("5th-Facebook", 98.71));
			loadHandler.receive(new PriceUpdate("5th-Google", 180.76));
			loadHandler.receive(new PriceUpdate("5th-Apple", 98.85));
			loadHandler.receive(new PriceUpdate("5th-Google", 180.71));
			loadHandler.receive(new PriceUpdate("5th-Facebook", 98.63));
			loadHandler.receive(new PriceUpdate("6th-Apple", 99.85));
			loadHandler.receive(new PriceUpdate("6th-Google", 190.71));
			loadHandler.receive(new PriceUpdate("6th-Facebook", 99.66));
			loadHandler.receive(new PriceUpdate("6th-Google", 190.73));
			loadHandler.receive(new PriceUpdate("6th-Facebook", 99.71));
			loadHandler.receive(new PriceUpdate("6th-Google", 190.76));
			loadHandler.receive(new PriceUpdate("6th-Apple", 99.85));
			loadHandler.receive(new PriceUpdate("6th-Google", 190.71));
			loadHandler.receive(new PriceUpdate("6th-Facebook", 99.63));
			loadHandler.receive(new PriceUpdate("6th-Apple", 99.85));
			loadHandler.receive(new PriceUpdate("6th-Google", 190.71));
			loadHandler.receive(new PriceUpdate("6th-Facebook", 99.66));
			loadHandler.receive(new PriceUpdate("6th-Google", 190.73));
			loadHandler.receive(new PriceUpdate("6th-Facebook", 99.71));
			loadHandler.receive(new PriceUpdate("6th-Google", 190.76));
			loadHandler.receive(new PriceUpdate("6th-Apple", 99.85));
			loadHandler.receive(new PriceUpdate("6th-Google", 190.71));
		}
	}

}
