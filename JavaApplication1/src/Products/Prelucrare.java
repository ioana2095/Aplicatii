/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import java.util.List;

/**
 *
 * @author Ioana
 */
public class Prelucrare {
    public Boolean prelucrareB(List<String> prod1)
    {
			if(Float.valueOf(prod1.get(4))<50.00 && Float.valueOf(prod1.get(4))>20.00 )
			{
				if(Float.valueOf(prod1.get(5))<1.2 && Float.valueOf(prod1.get(4))>0.7 )
				{
					if(prod1.get(6).toString().equals("Foarte placut") || prod1.get(6).toString().equals("Placut"))
					{
						if(Integer.valueOf(prod1.get(7))>=10)
						{
							if(Integer.valueOf(prod1.get(9))>=5)
							{
								return true;
							}
							else
							{
								return false;
							}		
						}
						else
						{
							return false;
						}
					}
					else
					{
						return false;
					}	
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
}
public Boolean prelucrareJ(List<String> prod1)
{
		if(Float.valueOf(prod1.get(4))<350.0 && Float.valueOf(prod1.get(4))>90.00 )
		{
			if(Float.valueOf(prod1.get(5))<4.5 && Float.valueOf(prod1.get(4))>0.5 )
			{
				if(prod1.get(6).toString().equals("Foarte bun") || prod1.get(6).toString().equals("Placut"))
				{
					if(Integer.valueOf(prod1.get(7))>10)
					{
						if(Integer.valueOf(prod1.get(9))>5)
						{
							return true;
						}
						else
						{
							return false;
						}		
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}	
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
}
public Boolean prelucrareA(List<String> prod1)
{
		if(Float.valueOf(prod1.get(4))<50.0 && Float.valueOf(prod1.get(4))>6.0 )
		{
			if(Float.valueOf(prod1.get(5))<4.5 && Float.valueOf(prod1.get(4))>0.5 )
			{
				if(prod1.get(6).toString().equals("Foarte bun") || prod1.get(6).toString().equals("Placut"))
				{
					if(Integer.valueOf(prod1.get(7))>10)
					{
						if(Integer.valueOf(prod1.get(9))>5)
						{
							return true;
						}
						else
						{
							return false;
						}		
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}	
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
}
}
