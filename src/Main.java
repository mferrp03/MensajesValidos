import java.util.Scanner;

public class Main {
		
		public static void main(String[]args) {
			boolean entry = true;
			int i = 0;
			int j = 0;
			String [] messages = new String[256];

			Scanner sc = new Scanner(System.in);
			do {
				try {
			
			messages[i] = sc.nextLine();
				}
				catch(Exception e) {
					entry = false;
				}
			i++;
			}
			while(entry);
			sc.close();
			do {
				String word = messages[j];
				char[] message = messages[j].toCharArray();
			
			if(isValid(word,message))
				System.out.println("Sí");
			else
				System.out.println("No");
				j++;
			}while(messages[j]!=null);
		}
		static boolean lowerCase(char[] array,int i) {
			boolean low = false;
			if (array[i]=='p'||array[i]=='q'||array[i]=='r'||array[i]=='s'||array[i]=='t'||array[i]=='u'||array[i]=='v'||array[i]=='w'||array[i]=='x'||array[i]=='y'||array[i]=='z')
				low = true;
			return low;
			
		}
		static boolean isValid(String message,char[] array) {
			boolean valid = true;
			int i = 0;
			do {
				if (!lowerCase(array,i)&& array[i]!='N'&& array[i]!='C'&& array[i]!='D'&& array[i]!='E'&& array[i]!='I')
					valid = false;
				else if(lowerCase(array,i))
					i++;
				else if(array[i]=='N') {
					if(i+1<message.length()) {
						if(lowerCase(array,i+1)) {
						i++;
						}
					else 
						i++;	
					}
				}
				else if(array[i]=='C'|| array[i]=='D'|| array[i]=='E'|| array[i]=='I') {
					if(i+1<message.length()) {
						if (lowerCase(array,i+1)) {
							if (i+2<message.length()) {
								if(lowerCase(array,i+2)) {
									if(message.length()!=i+3) {
										valid = false;
									}
									else i++;
								}
								else i++;
							}
							else valid = false;
						}
						else i++;
					}
				}
			}
			while(valid && i<message.length()&&(lowerCase(array,i)||array[i]=='N'||array[i]=='C'||array[i]=='D'||array[i]=='E'||array[i]=='I'));
			return valid;
		}

		
		
	

}
