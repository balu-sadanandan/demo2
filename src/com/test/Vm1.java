package com.test;

import java.util.Scanner;

public class Vm1 {
	public static void main(String[] args) {

		Vendingmachine vm =new Vendingmachine();
		while(true)
		{
			
		if(vm.dispmenu())
					vm.cashin();
		else
			vm.supplier();
		}
		
	}

}
