package hw05;

import java.util.ArrayList;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to be a 2D array/linkedlist
 * Other Comments: Please note that this class has 3 print methods to see each Array2D, 
 * one is to view column by column and the other is to view row by row another is to view strings and doubles
 */

public class Array2D<E> {
	private int rows;
	private int cols;
	private Array2DNode<E> head;
	private Array2DNode<E> rowTail;
	private Array2DNode<E> colTail;

	// Constructors
	public Array2D() {
		rows = 0;
		cols = 0;
		head = null;
		rowTail = null;
		colTail = null;
	}

	public Array2D(int rows, int cols) {
		if (rows < 0 || cols < 0) {
            throw new IndexOutOfBoundsException("This index is out of range");
        }
		// use addFirstRow/Col methods initialize number of rows
		for (int index = 0; index < rows; index++) {
			addFirstRow();
		}
		for (int index = 0; index < cols - 1; index++) {
			addFirstCol();
		}

	}

	public Array2D(E[][] input2DArr) {
		// get the number of rows and cols
		int numOfRows = input2DArr.length;
		int numOfCols = input2DArr[0].length;

		// initialize number of rows
		for (int index = 0; index < numOfRows; index++) {
			addFirstRow();
		}
		// initialize number of cols
		for (int index = 0; index < numOfCols - 1; index++) {
			addFirstCol();
		}

		// save the values from 2D array to the Array2D
		Array2DNode<E> rowStart = head;
		Array2DNode<E> currentCol = head;

		for (int i = 0; i < input2DArr.length; i++) {
			for (int j = 0; j < input2DArr[0].length; j++) {
				currentCol.setItem(input2DArr[i][j]);
				currentCol = currentCol.nextCol;
			}
			rowStart = rowStart.nextRow;
			currentCol = rowStart;
		}
	}

	// Adds a new column of empty nodes to the beginning of the list.
	public void addFirstCol() {
		// check to make sure the Array2D isn't empty
		if (this.isEmpty()) {
			this.head = new Array2DNode<E>();
			this.rowTail = head;
			this.colTail = head;
			rows++;
		} else {
			Array2DNode<E> currentRowNode = this.head;
			Array2DNode<E> newHead = new Array2DNode<E>();
			Array2DNode<E> firstNode = new Array2DNode<E>();
			Array2DNode<E> secondNode = new Array2DNode<E>();

			// link head to new head
			newHead = firstNode;

			// link all nodes that are not new head and rowTail to next column
			while (currentRowNode != null) {
				// connect currentNewNode to old col
				firstNode.nextCol = currentRowNode;
				// check to make sure there is a row that follows
				if (firstNode.nextCol.nextRow == null) {
					// if there is no need for another row then just delete
					break;
				}
				// connect second node to first node and next col
				firstNode.nextRow = secondNode;
				secondNode.nextCol = firstNode.nextCol.nextRow;

				// update all the nodes
				currentRowNode = currentRowNode.nextRow;
				secondNode = new Array2DNode<E>();
				firstNode = firstNode.nextRow;
			}

			// set new head and row tail
			this.head = newHead;
			this.rowTail = firstNode;
		}
		// increase the number of columns
		cols++;
	}

	// Adds a new row to the beginning of the list.
	public void addFirstRow() {
		// check to make sure the Array2D isn't empty
		if (this.isEmpty()) {
			this.head = new Array2DNode<E>();
			this.rowTail = head;
			this.colTail = head;
			cols++;
		} else {
			Array2DNode<E> currentColNode = this.head;
			Array2DNode<E> newHead = new Array2DNode<E>();
			Array2DNode<E> firstNode = new Array2DNode<E>();
			Array2DNode<E> secondNode = new Array2DNode<E>();

			// link head to new head
			newHead = firstNode;

			// link all nodes that are not new head and rowTail to next column
			while (currentColNode != null) {
				// connect currentNewNode to old col
				firstNode.nextRow = currentColNode;
				// check to make sure there is a row that follows
				if (firstNode.nextRow.nextCol == null) {
					// if there is no need for another col then just delete
					break;
				}
				// connect second node to first node and next col
				firstNode.nextCol = secondNode;
				secondNode.nextRow = firstNode.nextRow.nextCol;

				// update all the nodes
				currentColNode = currentColNode.nextCol;
				secondNode = new Array2DNode<E>();
				firstNode = firstNode.nextCol;
			}

			// set new head and col tail
			this.head = newHead;
			this.colTail = firstNode;
		}
		// increase the number of rows
		rows++;
	}

	// Adds a new column to the end of the list.
	public void addLastCol() {
		// check to make sure the Array2D isn't empty
		if (this.isEmpty()) {
			this.head = new Array2DNode<E>();
			this.rowTail = head;
			this.colTail = head;
			rows++;
		} else {
			// save a reference of all neccessary Nodes
			Array2DNode<E> currentRowNode = this.colTail;
			Array2DNode<E> newColTail = null;
			Array2DNode<E> firstNode = new Array2DNode<E>();
			Array2DNode<E> secondNode = new Array2DNode<E>();

			newColTail = firstNode;
			// connect each of the Nodes' next col
			while (currentRowNode != null) {
				// connect currentRowNode to firstNode
				currentRowNode.nextCol = firstNode;

				// check to make sure there is a row that follows
				if (currentRowNode.nextRow == null) {
					// if there is no need for another row then just delete
					break;
				}
				// connect first node to next row
				firstNode.nextRow = secondNode;

				// update all the nodes
				currentRowNode = currentRowNode.nextRow;
				secondNode = new Array2DNode<E>();
				firstNode = firstNode.nextRow;
			}

			// set the new rowTail
			this.colTail = newColTail;
		}
		// increase the number of columns
		cols++;
	}

	// Adds a new row to the end of the list.
	public void addLastRow() {
		// check to make sure the Array2D isn't empty
		if (this.isEmpty()) {
			this.head = new Array2DNode<E>();
			this.rowTail = head;
			this.colTail = head;
			cols++;
		} else {
			// save a reference of all necessary Nodes
			Array2DNode<E> currentColNode = this.rowTail;
			Array2DNode<E> newRowTail = null;
			Array2DNode<E> firstNode = new Array2DNode<E>();
			Array2DNode<E> secondNode = new Array2DNode<E>();

			newRowTail = firstNode;
			// connect each of the Nodes' next row
			while (currentColNode != null) {
				// connect currentColNode to firstNode
				currentColNode.nextRow = firstNode;

				// check to make sure there is a col that follows
				if (currentColNode.nextCol == null) {
					// if there is no need for another row then just exit
					break;
				}

				// set the next col of firstNode to secondNode
				firstNode.nextCol = secondNode;

				// update all the nodes
				currentColNode = currentColNode.nextCol;
				secondNode = new Array2DNode<E>();
				firstNode = firstNode.nextCol;
			}

			// set the new rowTail
			this.rowTail = newRowTail;
		}
		// increase the number of rows
		rows++;
	}

	// Inserts a column at the given index.
	public void insertCol(int index) {
		// check if the index is in bounds
		if (index < 0 || index > cols) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Must be within range: " + cols);
		}

		// if the index is at the end then addLastCol()
		if (index == this.cols) {
			this.addLastCol();
			cols--; // removes extra increment in addLastCol()
		}
		// if the index is at the beginning then addFirstCol()
		else if (index == 0) {
			this.addFirstCol();
			cols--; // removes extra increment in addFirstCol()
		} else {
			// save references of previous node and index node
			Array2DNode<E> previousNode = this.head;
			Array2DNode<E> followingNode = previousNode.nextCol;
			// the two nodes will be new null nodes
			Array2DNode<E> firstNode = new Array2DNode<E>();
			Array2DNode<E> secondNode = new Array2DNode<E>();

			// find the node at index and save
			for (int iteration = 1; iteration < index; iteration++) {
				previousNode = followingNode;
				followingNode = followingNode.nextCol;
			}

			// connect each of the nodes' nextCol in the correct order
			while (previousNode != null) {
				firstNode.nextCol = followingNode;
				previousNode.nextCol = firstNode;
				if (previousNode.nextRow == null) {
					// if there is no need for another row then just delete
					break;
				}
				// connect first node to next row
				firstNode.nextRow = secondNode;

				// update all the nodes
				previousNode = previousNode.nextRow;
				followingNode = followingNode.nextRow;
				secondNode = new Array2DNode<E>();
				firstNode = firstNode.nextRow;
			}

		}
		cols++;
	}

	// Inserts a row at the given index.
	public void insertRow(int index) {
		if (index < 0 || index > rows - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Must be within range: " + rows);
		}

		// if the index is at the end then addLastRow()
		if (index == this.rows) {
			this.addLastRow();
			rows--; // removes extra increment in addLastRow()
		}
		// if the index is at the beginning then addFirstRow()
		else if (index == 0) {
			this.addFirstRow();
			rows--; // removes extra increment in addFirstCol()
		} else {
			// save references of previous node and index node
			Array2DNode<E> previousNode = this.head;
			Array2DNode<E> followingNode = previousNode.nextRow;
			// the two nodes will be new null nodes
			Array2DNode<E> firstNode = new Array2DNode<E>();
			Array2DNode<E> secondNode = new Array2DNode<E>();

			// find the node at index and save
			for (int iteration = 1; iteration < index; iteration++) {
				previousNode = followingNode;
				followingNode = followingNode.nextRow;
			}

			// connect each of the nodes' nextRow in the correct order
			while (previousNode != null) {
				firstNode.nextRow = followingNode;
				previousNode.nextRow = firstNode;
				if (previousNode.nextCol == null) {
					// if there is no need for another row then just delete
					break;
				}
				// connect first node to next col
				firstNode.nextCol = secondNode;

				// update all the nodes
				previousNode = previousNode.nextCol;
				followingNode = followingNode.nextCol;
				secondNode = new Array2DNode<E>();
				firstNode = firstNode.nextCol;
			}

		}
		rows++;
	}

	// Removes the first column.
	public void deleteFirstCol() {
		// make sure the Array2D is not empty
		if (this.isEmpty()) {
			throw new RuntimeException("Array2D is empty! Nothing to delete");
		}
		// if the cols is 1 then set everything to null
		if (this.cols == 1) {
			this.head = this.rowTail = this.colTail = null;
		} else {
			// make the head equal the next col
			this.head = this.head.nextCol;
			this.rowTail = this.rowTail.nextCol;
		}
		this.cols--;
	}

	// Removes the first row.
	public void deleteFirstRow() {
		// make sure the Array2D is not empty
		if (this.isEmpty()) {
			throw new RuntimeException("Array2D is empty! Nothing to delete");
		}
		// if the rows is 1 then set everything to null
		if (this.rows == 1) {
			this.head = this.rowTail = this.colTail = null;
		} else {
			// make the head equal the next row
			this.head = this.head.nextRow;
			this.colTail = this.colTail.nextRow;
		}
		this.rows--;
	}

	// Removes the last column.
	public void deleteLastCol() {
		// if empty then state that it is
		if (this.isEmpty()) {
			throw new RuntimeException("Array2D is empty! Nothing to delete");
		}
		// if only one item then just set everything to null
		if (this.cols == 1) {
			this.head = this.rowTail = this.colTail = null;
		} else {
			// save references to all nodes that will be used
			Array2DNode<E> previous = this.head;
			Array2DNode<E> newColTail = null;

			// loop until you find the colTail and node before
			while (previous.nextCol != this.colTail) {
				previous = previous.nextCol;
			}

			// save the colTail for future reference
			newColTail = previous;

			while (previous != null) {
				// loop to next row and set nextCol to null
				previous.nextCol = null;
				previous = previous.nextRow;
			}

			// set the new colTail
			this.colTail = newColTail;
		}
		this.cols--;
	}

	// Removes the last row.
	public void deleteLastRow() {
		// if empty then state that it is
		if (this.isEmpty()) {
			throw new RuntimeException("Array2D is empty! Nothing to delete");
		}
		// if only one item then just set everything to null
		if (this.rows == 1) {
			this.head = this.rowTail = this.colTail = null;
		} else {
			// save references to all nodes that will be used
			Array2DNode<E> previousNode = this.head;
			Array2DNode<E> newRowTail = null;

			// loop until you find the colTail and node before
			while (previousNode.nextRow != this.rowTail) {
				previousNode = previousNode.nextRow;
			}

			// save the colTail for future reference
			newRowTail = previousNode;
			while (previousNode != null) {
				// loop to next col and set nextRow to null
				previousNode.nextRow = null;
				previousNode = previousNode.nextCol;
			}

			// set the new colTail
			this.rowTail = newRowTail;
		}
		this.rows--;
	}

	// Removes the column at the given index.
	public void deleteCol(int index) {
		// check if the index is in bounds
		if (index < 0 || index >= cols) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Must be within range: " + cols);
		}

		// if empty then state that it is
		if (this.isEmpty()) {
			throw new RuntimeException("Array2D is empty! Nothing to delete");
		}
		// if only one item then just set everything to null
		if (index == 0) {
			deleteFirstCol();
			cols++;
		} else if (index == cols) {
			deleteLastCol();
			cols++;
		} else {
			// save references of previous node and index node
			Array2DNode<E> previousNode = this.head;
			Array2DNode<E> followingNode = previousNode.nextCol;

			// find the node at index and save
			for (int iteration = 1; iteration < index; iteration++) {
				previousNode = followingNode;
				followingNode = followingNode.nextCol;
			}

			while (previousNode != null) {
				// loop to next row and set nextCol to null
				previousNode.nextCol = followingNode.nextCol;
				previousNode = previousNode.nextRow;
				followingNode = followingNode.nextRow;
			}

		}
		this.cols--;
	}

	// Removes the row at the given index.
	public void deleteRow(int index) {
		// check if the index is in bounds
		if (index < 0 || index >= rows) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Must be within range: " + rows);
		}

		// if empty then state that it is
		if (this.isEmpty()) {
			throw new RuntimeException("Array2D is empty! Nothing to delete");
		}
		// if only one item then just set everything to null
		if (index == 0) {
			deleteFirstRow();
			rows++;
		} else if (index == rows) {
			deleteLastRow();
			rows++;
		} else {
			// save references of previous node and index node
			Array2DNode<E> previousNode = this.head;
			Array2DNode<E> followingNode = previousNode.nextRow;

			// find the node at index and save
			for (int iteration = 1; iteration < index; iteration++) {
				previousNode = followingNode;
				followingNode = followingNode.nextRow;
			}

			while (previousNode != null) {
				// loop to next row and set nextCol to null
				previousNode.nextRow = followingNode.nextRow;
				previousNode = previousNode.nextCol;
				followingNode = followingNode.nextCol;
			}

		}
		this.rows--;
	}

	// Returns the item at the given (row, col).
	public E get(int row, int col) {
		// check if the row is in bounds
		if (row < 0 || row >= rows) {
			throw new IndexOutOfBoundsException("Index: " + row + ", Must be within range: " + rows);
		}
		// check if the col is in bounds
		if (col < 0 || col >= cols) {
			throw new IndexOutOfBoundsException("Index: " + col + ", Must be within range: " + cols);
		}
		E item = null;
		Array2DNode<E> currentNode = this.head;

		// loop until you reach the correct row and col
		for (int i = 0; i < row; i++) {
			currentNode = currentNode.nextRow;
		}
		for (int i = 0; i < col; i++) {
			currentNode = currentNode.nextCol;
		}
		item = currentNode.getItem();
		return item;
	}

	// Returns an ArrayList<E> which holds the values from the requested column.
	public ArrayList<E> getCol(int col) {
		ArrayList<E> valuesInCol = new ArrayList<E>();
		// check if the col is in bounds
		if (col < 0 || col >= cols) {
			throw new IndexOutOfBoundsException("Index: " + col + ", Must be within range: " + cols);
		}

		// create item holder and node for reference
		E currentItem = null;
		Array2DNode<E> currentNode = this.head;

		// loop until you find the correct column
		for (int i = 0; i < col; i++) {
			currentNode = currentNode.nextCol;
		}

		// loop until you get all the values in each column node
		while (currentNode != null) {
			currentItem = currentNode.getItem();
			valuesInCol.add(currentItem);
			currentNode = currentNode.nextRow;
		}
		return valuesInCol;
	}

	// Returns an ArrayList<E> which holds the values from the requested row.
	public ArrayList<E> getRow(int row) {
		ArrayList<E> valuesInRow = new ArrayList<E>();
		// check if the col is in bounds
		if (row < 0 || row >= rows) {
			throw new IndexOutOfBoundsException("Index: " + row + ", Must be within range: " + rows);
		}

		// create item holder and node for reference
		E currentItem = null;
		Array2DNode<E> currentNode = this.head;

		// loop until you find the correct column
		for (int i = 0; i < row; i++) {
			currentNode = currentNode.nextRow;
		}

		// loop until you get all the values in each column node
		while (currentNode != null) {
			currentItem = currentNode.getItem();
			valuesInRow.add(currentItem);
			currentNode = currentNode.nextCol;
		}
		return valuesInRow;
	}

	// Assigns the given item to the Array2DNode at position (row, col).
	public void set(int row, int col, E item) {
		// check if the row is in bounds
		if (row < 0 || row >= rows) {
			throw new IndexOutOfBoundsException("Index: " + row + ", Must be within range: " + rows);
		}
		// check if the col is in bounds
		if (col < 0 || col >= cols) {
			throw new IndexOutOfBoundsException("Index: " + col + ", Must be within range: " + cols);
		}
		Array2DNode<E> currentNode = this.head;

		// loop until you reach the correct row and col
		for (int i = 0; i < row; i++) {
			currentNode = currentNode.nextRow;
		}
		for (int i = 0; i < col; i++) {
			currentNode = currentNode.nextCol;
		}
		currentNode.setItem(item);
	}

	// Returns the number of columns.
	public int colSize() {
		return cols;
	}

	// Returns the number of rows.
	public int rowSize() {
		return rows;
	}

	// check if the Array2D is empty
	private boolean isEmpty() {
		return (this.rows == 0 && this.cols == 0 && this.head == null && this.rowTail == null && this.colTail == null);
	}

	// method that prints the values by each row
	public void printRowByRow() {
		Array2DNode<E> rowStart = head;
		Array2DNode<E> currentCol = head;
		while (rowStart != null) {
			while (currentCol != null) {
				// If you want to reduce spacing, decrease 5
				System.out.printf("%6d", currentCol.getItem());
				currentCol = currentCol.nextCol;

			}
			System.out.println();
			rowStart = rowStart.nextRow;
			currentCol = rowStart;
		}
		System.out.println("row size: " + rowSize());
		System.out.println("column size: " + colSize() + "\n");

	}

	// method that prints the values by each col
	public void printColByCol() {
		Array2DNode<E> colStart = head;
		Array2DNode<E> currentRow = head;
		while (colStart != null) {
			while (currentRow != null) {
				// If you want to reduce spacing, decrease 5
				System.out.printf("%6d", currentRow.getItem());
				currentRow = currentRow.nextRow;

			}
			System.out.println();
			colStart = colStart.nextCol;
			currentRow = colStart;
		}
		System.out.println("row size: " + rowSize());
		System.out.println("column size: " + colSize() + "\n");

	}
	
	// method that prints the values by each row
		public void printRowByRowStrings() {
			Array2DNode<E> rowStart = head;
			Array2DNode<E> currentCol = head;
			while (rowStart != null) {
				while (currentCol != null) {
					// If you want to reduce spacing, decrease 5
					System.out.print(" "+ currentCol.getItem());
					currentCol = currentCol.nextCol;

				}
				System.out.println();
				rowStart = rowStart.nextRow;
				currentCol = rowStart;
			}
			System.out.println("row size: " + rowSize());
			System.out.println("column size: " + colSize() + "\n");

		}

}
