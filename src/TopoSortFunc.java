import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class TopoSortFunc
{
	int numOfVertex;
	public String[] readInput(String inputFilePath)
	{
		File input = new File(inputFilePath);
		String data;
		String info = "";
		String[] splitInfo;
		int i;
		try
		{
			FileInputStream fis = new FileInputStream(inputFilePath);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			while((data = br.readLine()) != null)
			{
				splitInfo = data.split(" ");
				for(int j = 0; j < splitInfo.length; j++)
				{
					
				}
				//info += data + ",";//insert , line by line later to split out
				numOfVertex++;
			}
		}
		catch(IOException ex)
		{
			ex.getStackTrace();
		}
		splitInfo = info.split(",");
		return splitInfo;
	}
	public int[][] buildGraph(String[] graphInfo)
	{
		int[][] graph;
		
		
		
		
		
		
		return graph;
	}
	public void topoSort()
	{
		int [][] graph = buildGraph();
		int [] result = new int[numOfVertex];
		int count = 0;
		int j = 0;
		boolean skip = false;
		//init result
		for(int index = 0; index < result.length;index++)
		{
			result[index] = -1;
		}
		while(count < numOfVertex)
		{
			skip = false;
			for(int i = 0; i < numOfVertex; i++)
			{
				if(j == result[1])
				{
					skip = true;
				}
			}//for
			if(skip)
			{
				j++;
				skip = false;
				continue;
			}//if
			int total = 0;
			for(int i = 0; i<numOfVertex;i++)
			{
				if(graph[i][j] == 1)
				{
					total++;
				}
			}
			if(total == 0)
			{
				System.out.println(j+1);
				result[count++] = j;
				//make a line zero
				for(int k = 0; k < numOfVertex; k++)
				{
					graph[j][k] = 0;
				}
				j = 0;
			}//if
			else
			{
				j++;
			}
		}
	}

}
