import java.util.Scanner;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/5.
 */
public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        //调用方法
        int result = modify(str);
        System.out.println(result);
    }

    private static int modify(String str) {
        int length = str.length();

        //先考虑是否长度为奇数，如果为奇数，则肯定不通过
        if(length%2!=0){
            return 0;
        }else{
            for(int i=0;i<length-1;i=i+2) {
                char a = str.charAt(i);
                //考虑对应位置是否有符合的，首先，左符号应该永远是奇数，然后对应右符号位置应该是奇数差，即i+1,i+3,i+5....
                if(String.valueOf(a).equals("(")){
                    for(int j=i+1;j<length;j=j+2){
                        if(!String.valueOf(str.charAt(j)).equals(")")){
                            return 0;
                        }
                    }
                }else if(String.valueOf(a).equals("<")){
                    for(int j=i+1;j<length;j=j+2){
                        if(!String.valueOf(str.charAt(j)).equals(">")){
                            return 0;
                        }
                    }
                }else if(String.valueOf(a).equals("[")){
                    for(int j=i+1;j<length;j=j+2){
                        if(!String.valueOf(str.charAt(j)).equals("]")){
                            return 0;
                        }
                    }
                }else{
                    return 0;
                }
            }
        }
        return 1;
    }

}
