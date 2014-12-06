package View;

import java.util.ArrayList;

public class Genome 
{
	private int[] genes;
	Genome()
	{
		genes = new int[6];
		for(int i=0;i<6;i++)
		{
			this.genes[i]=0;
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
