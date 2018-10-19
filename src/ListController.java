import mylist.*;
import java.io.*;

class MyData implements Data {
    
    private int occurrence = 1;
    private final String word;
    
    MyData(String s) { this.word = s; }
    
    int getOccu() { return occurrence; }
    
    String getWord() { return word; }
    
    void addOccu() { occurrence++; }
    
}

public class ListController {

    private List list;
    private String[] strList;

    public ListController(String path) {
        readFile(path);
        reBuild();
    }

    private void readFile(String path) {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
                sb.append(" ");
            }
            s = new String(sb).replaceAll(",|\\.|\\(|\\)| (?= )", "").toLowerCase();
            this.strList = s.split(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void count(String word) {
        Pointer p = new Pointer(list);
        for (p.toHead(); !p.ifTail(); p.shift()) {
            MyData d = (MyData) p.getData();
            if (d.getWord().equals(word)) {
                d.addOccu();
                return;
            }
        }
        p.insert(new MyData(word));
    }

    public void reBuild() {
        list = new List();
        for (String s : strList)
            count(s);
    }

    public void print(String head) {
        StringBuffer sb = new StringBuffer(head);
        sb.append("\n");
        for (Pointer p = new Pointer(list); !p.ifTail(); p.shift()) {
            MyData d = (MyData) p.getData();
            sb.append(d.getWord());
            sb.append("(");
            sb.append(d.getOccu());
            sb.append(")-> ");
        }
        sb.append("END");
        System.out.println(new String(sb));
    }

    public void sort() { // Select Sort Ascending
        List sortList = new List();
        Pointer pointer = new Pointer(sortList);
        while (list.getSize() != 0) {
            Pointer min = new Pointer(list);
            MyData data = (MyData) min.getData();
            for (Pointer cur = new Pointer(list); !cur.ifTail(); cur.shift()) {
                MyData md = (MyData) cur.getData();
                if (md.getOccu() < data.getOccu()) {
                    min = cur.clone();
                    data = md;
                }
            }
            pointer.insert(data);
            min.delete();
        }
        this.list = sortList;
    }

    public void pick3Most(boolean largest) {
        this.sort();
        int count = 0;
        int sample = 0;
        Pointer p = new Pointer(list);
        if (largest) {
            for (p.toTail(); !p.ifHead(); p.reshi()) {
                MyData data = (MyData) p.getData();
                if (data.getOccu() != sample) {
                    sample = data.getOccu();
                    count++;
                }
                if (count > 3)
                    p.delete();
            }
        } else {
            for (p.toHead(); !p.ifTail(); p.shift()) {
                MyData data = (MyData) p.getData();
                if (data.getOccu() != sample) {
                    sample = data.getOccu();
                    count++;
                }
                if (count > 3)
                    p.delete();
            }
        }
    }

    public void deleteLessThan7() {
        Pointer p = new Pointer(list);
        for (p.toHead(); !p.ifTail(); p.shift()) {
            MyData data = (MyData) p.getData();
            if (data.getOccu() < 7)
                p.delete();
        }
    }
    
}
