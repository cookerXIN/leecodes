import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/4
 */
public class a {
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            int n=in.nextInt();
            int[][] nums = new int[n][n];

            //输入数组
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j]=in.nextInt();
                }
            }
            int sum=0;
            //找出相邻两个k之间的最短距离
            for (int i = 1; i < n; i++) {
                int flag=0;
                flag = test1(n - 1,i,i+1,nums);
                if (flag==-1){
                    System.out.println("无法到达");
                }
                else{
                    sum=sum+flag;
                    System.out.println("从"+i+"->"+(i+1)+",最短路为："+flag);
                }
            }
            System.out.println("最短路劲为："+sum);


        }

        //找出相邻两个k之间的最短距离并返回最短距离
        public static int test1(int n,int a,int b,int[][] nums){

            //把找到的相邻两个key之间的所有元素放在hashmap中，如果为空则不满足条件
            //【思路更正】最开始的思路是上面的，但是hashmap不满足提议，因为相同key的时候会替换，所有把他们分别放到数组中，基数为i，偶数为j
            List<Integer> listai=new ArrayList<>();
            List<Integer> listaj=new ArrayList<>();
            List<Integer> listbi=new ArrayList<>();
            List<Integer> listbj=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (nums[i][j]==a){
                        listai.add(i);
                        listaj.add(j);
                    }
                    if (nums[i][j]==b){
                        listbi.add(i);
                        listbj.add(j);
                    }
                }
            }

            int min=abs((listai.get(0)-listbi.get(0)))+abs((listaj.get(0)-listbj.get(0)));
            int len=0;
            //如果hashmap为空说明缺少k，返回-1
            if(listai.size()==0 || listaj.size()==0){
                return -1;
            }
            //找出从a->b的最短距离
            else{
                for (int i = 0; i < listai.size(); i++) {
                    int ai=listai.get(i);
                    int aj=listaj.get(i);
//                System.out.println("ai:"+ai+"  aj:"+aj);
                    for (int j = 0; j < listbi.size(); j++) {
                        int bi=listbi.get(j);
                        int bj=listbj.get(j);
//                    System.out.println("bi:"+bi+"  bj:"+aj);
                        len=abs((ai-bi))+abs((aj-bj));
//                    System.out.println(len);
                        min=(min<=len)? min: len;
//                    System.out.println(min);
                    }
                }
                return min;
            }

        }
        public static int abs(int a) {
            return (a < 0) ? -a : a;
        }
    }
