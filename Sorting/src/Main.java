
public class Main
{
	public static void printArr(int[] arr)
	{
		for (int i : arr) 
		{
			System.out.print(i + " ");
		}
	}

	public static void bubbleSort(int[] arr) 
	{
		for(int i = 0; i < arr.length; i++) 
		{
			for (int j = 0; j < arr.length - 1 - i; j++) 
			{
				if (arr[j] > arr[j + 1]) 
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp; 
				}
			}
		}
	}
	
	public static void selectionSort(int[] arr) 
	{
		int minIndex, temp;
		for(int i = 0; i < arr.length; i ++) 
		{
			minIndex = i;
			for(int j = i; j < arr.length; j++) 
			{
				if(arr[j] < arr[minIndex]) 
				{
					minIndex = j;
				}
			}
			
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	public static void insertionSort(int[] arr) 
	{
		int counter, temp, index;
		for(int i = 1; i < arr.length; i++) 
		{			
			index = 0;
			
			counter = i - 1;	
			temp = arr[i];
			while(counter >= 0) 
			{
				if(arr[i] < arr[counter] ) 
				{
					counter--;
				}
				else 
				{
					index = counter + 1;
					break;
				}
			}
			
			for(int j = i; j > index; j--) 
			{
				arr[j] = arr[j - 1];
			}
			arr[index] = temp;
			
		}
	}
	
	public static void main(String[] args) 
	{
		int[] arr = {9, 5, 7, 2, 6, 1}; 
		
		insertionSort(arr);
		printArr(arr);
	}
}
