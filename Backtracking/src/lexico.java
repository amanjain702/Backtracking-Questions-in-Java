
public class lexico {

	public static void main(String[] args) {
		lexico(0,1000);
	}

	public static void lexico(int curr, int end) {
		if(curr>end){
			return;
		}
		System.out.println(curr);
		if(curr==0){
			for(int i=1;i<=9;i++){
				lexico(10*curr +i,end);
			}
		}
		else{
			for(int i=0;i<=9;i++){
				lexico(10*curr +i,end);
			}
			
		}
		
	}

}
