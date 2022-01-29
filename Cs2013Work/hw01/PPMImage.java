package hw01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to serve as the basis for reading a PPMImage and altering its pixel data to manipulate how the image looks
 * Other Comments: Note: for this program to work ppm_images has to be a folder in the workspace, 
 * inside is another folder named ppm_images with all the photos provided in alphabetical order.
 */
public class PPMImage {
	private String magicNumber;
	private int width = 0;
	private int height = 0;
	private int maxColorVal;
	private int numOfPixels;
	// this array holds the pixel info/data
	private char[] raster = new char[numOfPixels];
	public static Scanner in = new Scanner(System.in);

	public PPMImage(String imageFileName) {
		// load data into object (has to be .ppm/use try-catch)
		readImage(imageFileName);

	}

	// write image onto new ppm file
	public void writeImage(String outputImageFileName) {
		try {
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputImageFileName));

			// Writing the magic number to a file
			byte[] magicNumBytes = magicNumber.getBytes(); // magic number is a String in this case
			output.write(magicNumBytes);

			// Writing the width and height to a file
			output.write(String.valueOf(width).getBytes());
			output.write(32);
			output.write(String.valueOf(height).getBytes());
			output.write(10);

			// write the max color value
			output.write(String.valueOf(maxColorVal).getBytes());
			output.write(10);

			// write the bytes of pixels
			for (int i = 0; i < raster.length; i++) {
				output.write(raster[i]);
			}

			output.flush();
			output.close();
			System.out.println("Successfully copied image!");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// read image and load all data into variables
	public void readImage(String imageFileName) {
		try {
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(imageFileName));
			// Read the "magic number" from the file.
			byte[] magicNumBytes = new byte[3];
			input.read(magicNumBytes);
			magicNumber = new String(magicNumBytes);

			// Read the width and height
			int widthReader, bytesReadWidth = 0; // for finding the width
			String widthText = "";
			while ((widthReader = input.read()) != 32) {
				widthText += (char) widthReader;
				bytesReadWidth++;
			}
			width = Integer.parseInt(widthText);

			int heightReader, bytesReadHeight = 0; // for finding the height
			String heightText = "";
			while ((heightReader = input.read()) != 10) {
				heightText += (char) heightReader;
				bytesReadHeight++;
			}
			height = Integer.parseInt(heightText);
			numOfPixels = width * height * 3;

			// Read the "maxColorVal"
			int maxColorValReader, bytesReadMaxColorVal = 0;
			String maxColorValText = "";
			while ((maxColorValReader = input.read()) != 10) {
				maxColorValText += (char) maxColorValReader;
				bytesReadMaxColorVal++;
			}
			maxColorVal = Integer.parseInt(maxColorValText);
			raster = new char[numOfPixels];

			// Read the pixel data
			for (int i = 0; i < raster.length; i++) {
				raster[i] = (char) input.read();
			}

			input.close();
			System.out.println("Successfully read image!");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// convert pixels from color to grey
	public void grayscale() {
		for (int index = 2; index < raster.length; index += 3) {
			// get the RGB values
			double red = raster[index - 2];
			double green = raster[index - 1];
			double blue = raster[index];

			// calculate the prime values
			double primeR = (red * 0.299) + (green * 0.587) + (blue * 0.114);
			double primeG = (red * 0.299) + (green * 0.587) + (blue * 0.114);
			double primeB = (red * 0.299) + (green * 0.587) + (blue * 0.114);

			// set all the modified values
			if (primeR > 255) {
				raster[index - 2] = (char) (255); // this is to set the red pixels
			} else {
				raster[index - 2] = (char) primeR;
			}
			if (primeG > 255) {
				raster[index - 1] = (char) (255); // this is to set the green pixels
			} else {
				raster[index - 1] = (char) primeG;
			}
			if (primeB > 255) {
				raster[index] = (char) (255); // this is to set the blue pixels
			} else {
				raster[index] = (char) primeB;
			}
		}
	}

	public void sepia() {
		for (int index = 2; index < raster.length; index += 3) {
			// get the RGB values
			double red = raster[index - 2];
			double green = raster[index - 1];
			double blue = raster[index];

			// calculate the prime values
			double primeR = (red * 0.393) + (green * 0.769) + (blue * 0.189);
			double primeG = (red * 0.349) + (green * 0.686) + (blue * 0.168);
			double primeB = (red * 0.272) + (green * 0.534) + (blue * 0.131);

			// set all the modified values
			if (primeR > 255) {
				raster[index - 2] = (char) (255); // this is to set the red pixels
			} else {
				raster[index - 2] = (char) primeR;
			}
			if (primeG > 255) {
				raster[index - 1] = (char) (255); // this is to set the green pixels
			} else {
				raster[index - 1] = (char) primeG;
			}
			if (primeB > 255) {
				raster[index] = (char) (255); // this is to set the blue pixels
			} else {
				raster[index] = (char) primeB;
			}
		}
	}

	public void negative() {
		for (int index = 2; index < raster.length; index += 3) {
			// get the RGB values
			double red = raster[index - 2];
			double green = raster[index - 1];
			double blue = raster[index];

			// calculate the prime values
			double primeR = 255 - red;
			double primeG = 255 - green;
			double primeB = 255 - blue;

			// set all the modified values
			raster[index - 2] = (char) primeR;
			raster[index - 1] = (char) primeG;
			raster[index] = (char) primeB;

		}
	}

	// helper methods to organize the console
	public static void printMenu() {
		System.out.println("____________OPTIONS_______________");
		System.out.println("1.)\twrite image that is grayscale");
		System.out.println("2.)\twrite image that is sepia");
		System.out.println("3.)\twrite image tht is negative");
		System.out.println("4.)\texit");
		System.out.println();
	}

	public static void manipulationHandler(PPMImage userImage, int chosenManipulation) {
		switch (chosenManipulation) {
		case 1:
			userImage.grayscale();
			System.out.println();
			break;
		case 2:
			userImage.sepia();
			System.out.println();
			break;
		case 3:
			userImage.negative();
			System.out.println();
			break;
		case 4:
			System.out.println("Successfully exited program");
			System.exit(0);
			break;
		default:
			System.out.println("Please type in a valid number from (1-4)");
			System.out.println();
		}

	}

	public static void showImageNamesInFolder() {
		System.out.println("____________LIST OF IMAGES AVAILABLE_______________");
		System.out.println("1.)\tblue_bird.ppm");
		System.out.println("2.)\tbridge.ppm");
		System.out.println("3.)\tcat.ppm");
		System.out.println("4.)\tdog.ppm");
		System.out.println("5.)\tdrink.ppm");
		System.out.println("6.)\tmacaw.ppm");
		System.out.println("7.)\tmonalisa.ppm");
		System.out.println("8.)\trainbow_flower.ppm");
		System.out.println("9.)\texit");
		System.out.println();
	}

	public static int handleUserInput() {
		int userOptionChosenImage;
		showImageNamesInFolder();
		System.out.print("Type in the number of a ppm image you want to use (type in 9 to exit): ");
		userOptionChosenImage = in.nextInt();
		return userOptionChosenImage;
	}

	public static String imageSwitchCase(int userChoice) {
		String imageString = null;
		switch (userChoice) {
		case 1:
			System.out.println("Using blue_bird.ppm");
			imageString = "ppm_images/ppm_images/blue_bird.ppm";
			System.out.println();
			break;
		case 2:
			System.out.println("Using bridge.ppm");
			imageString = "ppm_images/ppm_images/bridge.ppm";
			System.out.println();
			break;
		case 3:
			System.out.println("Using cat.ppm");
			imageString = "ppm_images/ppm_images/cat.ppm";
			System.out.println();
			break;
		case 4:
			System.out.println("Using dog.ppm");
			imageString = "ppm_images/ppm_images/dog.ppm";
			System.out.println();
			break;
		case 5:
			System.out.println("Using drink.ppm");
			imageString = "ppm_images/ppm_images/drink.ppm";
			System.out.println();
			break;
		case 6:
			System.out.println("TUsing macaw.ppm");
			imageString = "ppm_images/ppm_images/macaw.ppm";
			System.out.println();
			break;
		case 7:
			System.out.println("Using monalisa.ppm");
			imageString = "ppm_images/ppm_images/monalisa.ppm";
			System.out.println();
			break;
		case 8:
			System.out.println("Using rainbow_flower.ppm");
			imageString = "ppm_images/ppm_images/rainbow_flower.ppm";
			System.out.println();
			break;
		case 9:
			System.out.println("Successfully exited program");
			System.exit(0);
			break;
		default:
			System.out.println("Please type in a valid number from (1-9)");
			System.out.println();
		}
		return imageString;

	}

	// main method to test/run
	public static void main(String[] args) {
		int option;
		do {
			option = handleUserInput();
			String userImage = imageSwitchCase(option);
			PPMImage myImage = new PPMImage(userImage);
			int userManipulation = 0;
			do {
				printMenu();
				System.out.print("Choose what you would like to do to the image: ");
				userManipulation = in.nextInt();
				manipulationHandler(myImage, userManipulation);
				String desiredName = "";
				String ending;
				do {
					System.out.print("Type in the desired file name (must be .ppm): ");
					desiredName = in.next();
					ending = desiredName.substring(desiredName.length() - 4);
				} while (!ending.equals(".ppm"));
				myImage.writeImage(desiredName);
				System.out.println("Your file is ready to view!");
				System.out.println();
			} while (userManipulation > 4 || userManipulation < 1);
		} while (option != 9);

	}
}
