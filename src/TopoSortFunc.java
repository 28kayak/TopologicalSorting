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
		int[][] graph;
		try
		{
			FileInputStream fis = new FileInputStream(inputFilePath);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			while((data = br.readLine()) != null)
			{
				info += data + ",";//insert , line by line later to split out
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
		int[][] graph = new int[numOfVertex][numOfVertex];
		for(int i = 0; i< numOfVertex; i++)
		{
			for(int j = 0; j < numOfVertex; j++)
			{
				graph[i][j] = 0;
			}
		}
		
		for(int i = 0; i < numOfVertex-1; i++)
		{
			String[] strGraph = graphInfo[i].split(" ");
			int leng = strGraph.length;
			
			for(int k = 1; k < leng; k++)
			{
				graph[Integer.parseInt(strGraph[0])][Integer.parseInt(strGraph[k])] = 1;
				System.out.println("k=  " + k +"i =  " + i + "graph =" + graph[Integer.parseInt(strGraph[0])][Integer.parseInt(strGraph[k])] );
			}
		}
		return graph;
	}
	public void topoSort(String filePath)
	{
		int [][] graph = buildGraph(readInput(filePath));
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
			for(int i = 0; i < numOfVertex ;i++)
			{
				if(graph[i][j] == 1)
				{
					total++;
				}
			}
			if(total == 0)
			{
				System.out.println("j+1 = " + j+1);
				result[count++] = j;
				for(int i = 0; i < result.length; i++)
				{
					System.out.println(result[i]);
				}
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
