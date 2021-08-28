import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (x == 0)
				cnt += 1;
			else
				list.add(x);
		}
		Set<Integer> set = new HashSet<>();
		set.addAll(list);
		list.clear();
		list.addAll(set);
		
		Collections.sort(list);
		
		int answer = 0;
		
		if(list.isEmpty()) answer = cnt;
		
		//System.out.println(list);
		//System.out.println(cnt);
		for (int i = 0; i < list.size() - 1; i++) {
			int tmp = cnt, len = 1, cur = list.get(i);
			
			//if(list.size()-i<answer) break;
			
			for (int j = i + 1; j < list.size(); j++) {
				//System.out.println(cur+" "+tmp);
				if (list.get(j) - cur == 1) {
					len += 1; cur = list.get(j);
				}
				else {
					if(tmp>0) {
						cur+=1; tmp-=1; len+=1; j-=1;
					} else {
						//System.out.println(cur+" "+tmp);
						
						answer = (answer<len)?len:answer;
						break;
					}
				}
				if(j==list.size()-1) {
					if(tmp>0)
						answer = (answer<len+tmp)?len+tmp:answer;
					else
						answer = (answer<len)?len:answer;
				}
			}
		}//i
		System.out.println(answer);
	}// main

}
