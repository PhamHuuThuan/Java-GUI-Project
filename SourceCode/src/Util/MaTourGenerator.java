package Util;

import BUS.Tour_Bus;

public class MaTourGenerator {
	Tour_Bus tourBus = new Tour_Bus();
	public String sinhMaTour() {
		String maNew = "T";
		String maPre = tourBus.getMaTourMax();
		int ma = Integer.parseInt(maPre.substring(1));
		int i = 100;
		while(ma<i && i>0) {
			maNew+='0';
			i/=10;
		}
		maNew += String.valueOf(ma+1);
		System.out.println(maPre+" | "+ma+" | "+maNew);
		return maNew;
	}
}
