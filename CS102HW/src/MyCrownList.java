
public class MyCrownList implements FunnyList 
{
	Node thisList = new Node();
	int size = 0;
	
	public static void main(String[] args)
	{
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		
		MyCrownList thisList = new MyCrownList();

		thisList.append(a);
		thisList.prepend(b);
		thisList.append(c);
		thisList.insert(0,d);
		thisList.printList();
		thisList.insert(5, e);
		thisList.insert(-3, e);
		thisList.printList();
		
		MyCrownList listL = new MyCrownList();
		listL.append(new Node("woo"));
		listL.printList();
		listL.append(new Node("boo"));
		listL.printList();
		
		thisList.splice(listL.thisList.next);
		thisList.printList();
	}
	
	@Override
	public void prepend(Node u) 
	{
		u.next = thisList.next;
		thisList.next = u;
		size++;
	}

	@Override
	public void append(Node u) 
	{
		if(thisList.next == null)
		{
			thisList.next = u;
		}
		else
		{
			Node temp = thisList.next;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = u;
		}
		size++;
	}

	@Override
	public void insert(int i, Node u) 
	{
		if(i == 0)
		{
			u.next = thisList.next;
			thisList.next = u;
			size++;
		}
		else if(i < 0)
		{
			Node temp = thisList.next;
			i *= -1;
			if( i < size)
			{
				for(int j = 1; j < (size - i);j++)
				{
					if(temp.next != null)
					{
						temp = temp.next;
					}
				}
				if(temp.next == null)
				{
					temp.next = u;
				}
				else
				{
					u.next = temp.next;
					temp.next = u;
				}
				size++;
			}
			else
			{
				System.out.println("Exceeded bound");
			}
		}
		else
		{
			Node temp = thisList.next;
			for(int k = 0; k < i-1; k++)
			{
				if(temp.next == null)
				{
					System.out.println("Exceeded bound");
					break;
				}
				temp = temp.next;
			}
			if(temp.next != null)
			{
				u.next = temp.next;
				temp.next = u;
				size++;
			}
		}
	}

	@Override
	public void printList() 
	{
		Node temp = thisList.next;
		while(temp != null)
		{
			System.out.print("" + temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	@Override
	public void splice(Node L) 
	{
		Node temp = thisList.next;
		Node tempL = L;
		MyCrownList tempList = new MyCrownList();

		while(temp != null && tempL != null)
		{
			tempList.append(new Node(temp.value));
			temp = temp.next;
			tempList.append(new Node(tempL.value));
			tempL = tempL.next;
		}

		while(temp != null)
		{
			tempList.append(new Node(temp.value));
			temp = temp.next;
		}
		while(tempL != null)
		{
			tempList.append(new Node(tempL.value));
			tempL = tempL.next;

		}
		this.thisList = tempList.thisList;
	}

	@Override
	public Node split() 
	{
		Node temp = thisList.next;
		for(int i = 0; i < size/ 2; i ++)
		{
			temp = temp.next;
		}
		Node returnNode = temp.next;
		temp.next = null;
		return returnNode;
	}
}
