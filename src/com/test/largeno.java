package com.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class largeno {
	public static void main(String[] args) {
		int[] arr={3,30,34,5,9};
		int temp;
		for(int i=0;i<Array.getLength(arr);i++)
		{
			for(int j=0;j<Array.getLength(arr)-i-1;j++)
			{
				if(Integer.parseInt(Integer.toString(arr[j])+Integer.toString(arr[j+1]))<Integer.parseInt(Integer.toString(arr[j+1])+Integer.toString(arr[j])))
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			
			}
		}
		
		//System.out.println(Arrays.toString(arr));
		String str= new String();
		for(int i=0;i<Array.getLength(arr);i++)
		{
			str=str.concat(Integer.toString(arr[i]));
		}
		System.out.println(str);
		
			
	}

}
