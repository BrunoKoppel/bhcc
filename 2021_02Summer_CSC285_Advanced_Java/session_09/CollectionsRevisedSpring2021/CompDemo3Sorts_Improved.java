
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//-------------employee class ------------//
class EmployeeRec
{
	private String name;
	private String address;
	private double totalHours;
	private double rate;
	private int numDependants;
	private char gender;
	private boolean hasDegree;

	EmployeeRec(String name, String address, double hours, double payRate, int numDependents, char gender,
			boolean degree) throws Exception
	{
		this.setName(name);
		this.setAddress(address);
		this.setTotalHours(hours);
		this.setPayRate(payRate);
		this.setNumDependents(numDependents);
		this.setGender(gender);
		this.setDegree(degree);
	}

	private void setPayRate(double payRate) throws Exception
	{
		if (payRate >= 0)
		{
			this.rate = payRate;
		}
		else
		{
			throw new Exception("Pay rate must be positive");
		}
	}

	private void setDegree(boolean degree)
	{
		hasDegree = degree;
	}

	private void setGender(char ch) throws Exception
	{
		ch = Character.toLowerCase(ch);

		if (ch == 'm')
		{
			this.gender = ch;
		}
		else if (ch == 'f')
		{
			this.gender = ch;
		}
		else
		{
			throw new Exception("Gender must be male or female");
		}
	}

	public void setTotalHours(double hours) throws Exception
	{
		if (hours >= 0)
		{
			this.totalHours = hours;
		}
		else
		{
			throw new Exception("Hours must be greater than or equal to zero.");
		}
	}

	public void setNumDependents(int num) throws Exception
	{
		if (num >= 0)
		{
			this.numDependants = num;
		}
		else
		{
			throw new Exception("Number of dependents cannot be negative");
		}
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getAddress()
	{
		return address;
	}

	public double getHours()
	{
		return totalHours;
	}

	public int getDependenal()
	{
		return numDependants;
	}

	public double getRate()
	{
		return rate;
	}

	public char getGender()
	{
		return gender;
	}

	public String toString()
	{
		// String name, String address, double hours, double payRate, int numDependents,
		// char gender, boolean degree)
		return ("\n Name:    " + name + "\n Address: " + address + "\n Hours:   " + totalHours + "\n Pay Rate " + rate
				+ "\n Number of Dependents " + numDependants) + "\n Gender: " + gender + "\n Degree: " + hasDegree;
	}
}

public class CompDemo3Sorts_Improved
{
	private static ArrayList<EmployeeRec> empRecList = null;

	public static void main(String args[]) throws IOException
	{

		if (args.length == 0)
		{
			empRecList = manuallyLoadList();
		}
		else
		{
			empRecList = loadLFromFile(args[0]);
		}

		while (true)
		{
			boolean done = false;

			// String name, String address, double hours, double payRate, int numDependents,
			// char gender, boolean degree)
			System.out.println("How would you like to sort the employees? Enter Selection." + "\n1.) Name"
					+ "\n2.) Address" + "\n3.) Hours" + "\n4.) Pay Rate" + "\n5.) Number Of Dependants"
					+ "\n6.) Gender" + "\n7.) Exit" + "\n\nPlease Enter Selection");

			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();

			switch (choice)
			{
			case 1:
				// name
				Collections.sort(empRecList, new MyCompName());
				break;

			case 2:
				// address
				Collections.sort(empRecList, new MyCompAddress());
				break;

			case 3:
				// hours
				Collections.sort(empRecList, new MyCompHours());
				break;

			case 4:
				// pay rate
				Collections.sort(empRecList, new MyCompRate());
				break;

			case 5:
				// num dependents
				Collections.sort(empRecList, new MyCompDependents());
				break;

			case 6:
				// gender
				Collections.sort(empRecList, new MyCompGender());
				break;

			case 7:
				// exit
				done = true;
				break;
			}

			if (done)
			{
				break;
			}
			else
			{
				printList();
			}
		}

	}

	private static void printList()
	{
		Iterator<EmployeeRec> interator = empRecList.iterator();
		int i = 1;

		while (interator.hasNext())
		{
			Object element = interator.next();
			System.out.print(i + ".) " + element.toString() + "\n");// calls the toString()
			i++;
		} // while
		System.out.println();
	}

	private static ArrayList<EmployeeRec> loadLFromFile(String fileName)
	{
		ArrayList<EmployeeRec> empRecList = new ArrayList<>();
		try
		{
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			String name, address;
			double hours, payRate;
			int numDependents;
			char gender;
			boolean degree;

			while ((line = bufferedReader.readLine()) != null)
			{
				String[] entry = line.split("%");

				name = entry[0];
				address = entry[1];
				hours = Double.parseDouble(entry[2]);
				payRate = Double.parseDouble(entry[3]);
				numDependents = Integer.parseInt(entry[4]);
				gender = entry[5].charAt(0);
				degree = (entry[6].equals("t") ? true : false);

				EmployeeRec tempRec = new EmployeeRec(name, address, hours, payRate, numDependents, gender, degree);
				empRecList.add(tempRec);
				// System.out.println("You just added: \n" + tempRec.toString() + "\n");
			}

			fileReader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return empRecList;
	}

	private static ArrayList<EmployeeRec> manuallyLoadList()
	{
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<EmployeeRec> empRecList = new ArrayList<EmployeeRec>();

		String name, address;
		double hours, payRate;
		int numDependents;
		char gender;
		boolean degree;
		int curEntryNum = 1;
		for (;;)
		{
			try
			{
				System.out.println("Enter Info For Employee " + curEntryNum + ", or 'done'\n");

				System.out.print("Employee Name: ");
				name = inData.readLine();

				if (name.equalsIgnoreCase("done"))
				{
					System.out.println("---entry done---\n");
					break;
				}

				System.out.print("Address: ");
				address = inData.readLine();

				System.out.print("Hours: ");
				hours = Double.parseDouble(inData.readLine());

				System.out.print("Hourly Pay Rate: ");
				payRate = Double.parseDouble(inData.readLine());

				System.out.print("Number of Dependents: ");
				numDependents = Integer.parseInt(inData.readLine());

				System.out.print("Gender, m or f: ");
				gender = (char) (inData.read());
				inData.readLine();

				System.out.print("Degree, y or n: ");
				char temp = Character.toLowerCase((char) (inData.read()));
				inData.readLine();

				if (temp != 'y' && temp != 'n')
				{
					throw new Exception("Must Enter y or n.");
				}
				degree = (temp == 'y' ? true : false);

				EmployeeRec employee = new EmployeeRec(name, address, hours, payRate, numDependents, gender, degree);
				empRecList.add(employee);

				curEntryNum++;
				System.out.println();
			}
			catch (Exception e)
			{
				System.out.println("Entry Problem. " + e.getMessage());
			}

		}
		return empRecList;
	}
}

class MyCompName implements Comparator<Object>
{
	public int compare(Object emp1, Object emp2)
	{
		String emp1Name = ((EmployeeRec) emp1).getName();
		String emp2Name = ((EmployeeRec) emp2).getName();
		return emp1Name.compareTo(emp2Name);
	}
}

class MyCompHours implements Comparator<Object>
{
	public int compare(Object emp1, Object emp2)
	{
		double emp1Hours = ((EmployeeRec) emp1).getHours();
		double emp2Hours = ((EmployeeRec) emp2).getHours();
		return (emp1Hours <= emp2Hours) ? +1 : -1;
	}
}

class MyCompAddress implements Comparator<Object>
{
	public int compare(Object emp1, Object emp2)
	{
		String emp1Address = ((EmployeeRec) emp1).getAddress();
		String emp2Address = ((EmployeeRec) emp2).getAddress();
		return emp1Address.compareTo(emp2Address);
	}
}

class MyCompRate implements Comparator<Object>
{
	public int compare(Object emp1, Object emp2)
	{
		double emp1Rate = ((EmployeeRec) emp1).getRate();
		double emp2Rate = ((EmployeeRec) emp2).getRate();
		return ((emp1Rate <= emp2Rate) ? 1 : -1);
	}
}

class MyCompDependents implements Comparator<Object>
{
	public int compare(Object emp1, Object emp2)
	{
		int emp1Dependenal = ((EmployeeRec) emp1).getDependenal();
		int emp2Dependenal = ((EmployeeRec) emp2).getDependenal();
		return emp2Dependenal - emp1Dependenal;
	}
}

class MyCompGender implements Comparator<Object>
{
	public int compare(Object emp1, Object emp2)
	{
		char emp1Gender = ((EmployeeRec) emp1).getGender();
		char emp2Gender = ((EmployeeRec) emp2).getGender();
		return emp1Gender - emp2Gender;
	}
}
