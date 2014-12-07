package Elements;

import java.util.ArrayList;
import java.util.Random;

public class Genome 
{
	private int[] genes;
	Genome()
	{
		Random rn = new Random();
		genes = new int[6];
		for(int i=0;i<6;i++)
		{
			this.genes[i]=rn.nextInt(90)+10;
		}
	}
	void setGenes(ArrayList<Integer> p_genes)
	{
		for(int i=0;i<6;i++)
		{
			this.genes[i] = p_genes.get(i).intValue();
		}
	}
	Integer getGene(int p_geneNr)
	{
		return new Integer(this.genes[p_geneNr]);
	}
}
