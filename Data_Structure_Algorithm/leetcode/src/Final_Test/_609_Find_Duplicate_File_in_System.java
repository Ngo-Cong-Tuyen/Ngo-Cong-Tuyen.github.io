package Final_Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _609_Find_Duplicate_File_in_System {
    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        List<List<String>> list = new ArrayList<>();
        list= findDuplicate(paths);
        System.out.println(list);
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<>();
        List<String> groups = new ArrayList<>();
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        for (String str: paths){
            String directory;
            int n = str.indexOf(' ');
            int p = 0;
            int q = 0;
            directory = str.substring(0,n);
            n=0;
            while (q!= str.length()-1){
                n= str.indexOf(' ', n+1);
                p= str.indexOf('(', p+1);
                q= str.indexOf(')', q+1);
                StringBuilder sb = new StringBuilder();
                sb.append(directory);
                sb.append("/");
                sb.append(str.substring(n+1,p));
                String key = str.substring(p+1,q);
                if (hashMap.containsKey(key)){
                    hashMap.get(key).add(sb.toString());
                } else {
                    ArrayList<String> arrayList =new ArrayList<>();
                    arrayList.add(sb.toString());
                    hashMap.put(key, arrayList);
                }
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry: hashMap.entrySet()) {
            if (entry.getValue().size()>1){
                list.add(entry.getValue());
            }
        }
        return list;
    }
}
