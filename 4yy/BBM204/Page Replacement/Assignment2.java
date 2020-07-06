import java.io.PrintWriter;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;


class Assignment2 {

    class BST<Key extends Comparable<Key>>{

        class Node{

            Key data;
            Node left, right;

            public Node(Key item)
            {
                data = item;
                left = right = null;
            }
        }

        Node root;

        BST(){
            root = null;
        }

        void deleteKey(Key key){
            root = deleteRec(root, key);
        }

        Node deleteRec(Node root, Key key){
            if (root == null)  return root;

            if (key.compareTo(root.data)<0)
                root.left = deleteRec(root.left, key);
            else if (key.compareTo(root.data)>0)
                root.right = deleteRec(root.right, key);

            else
            {
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;

                root.data = minValue(root.right);

                root.right = deleteRec(root.right, root.data);
            }

            return root;
        }

        Key minValue(Node root){
            Key minv = root.data;
            while (root.left != null)
            {
                minv = root.left.data;
                root = root.left;
            }
            return minv;
        }

        void insert(Key key){
            root = insertRec(root, key);
        }


        Node insertRec(Node root, Key key){

            if (root == null)
            {
                root = new Node(key);
                return root;
            }

            if (key.compareTo(root.data)<0)
                root.left = insertRec(root.left, key);
            else if (key.compareTo(root.data)>0)
                root.right = insertRec(root.right, key);

            return root;
        }

        boolean contain(Key el){
            return contains(el,root) != null;
        }

        Node contains(Key el, Node cur){
            if(cur==null) return null;
            int cmp = el.compareTo(cur.data);
            if(cmp<0) return contains(el,cur.left);
            else if(cmp>0) return contains(el,cur.right);
            else return cur;
        }

        void inorder(){
            inorderRec(root);
        }

        void inorderRec(Node root){
            if (root != null)
            {
                out.print(root.data + " ");
                inorderRec(root.left);
                inorderRec(root.right);
            }
        }

    }

    class MainMemory<Key extends Comparable<Key>>{

        Key[] printList;
        int count;

        MainMemory (int memory){
            printList = (Key[]) new Comparable[memory];
            count=0;
        }

        void add(Key el){
            printList[count++]=el;
        }

        void add(Key del,Key ad){
            for(int i=0;i<count;i++){
                if(printList[i].compareTo(del)==0){
                    printList[i]=ad;
                    break;
                }
            }
        }

        void printFckList(){
            for(int i=0;i<count;i++)
                out.print(printList[i]+" ");
            out.print("\n");
        }

        void printFckList(Key[] sql){
            for(int i=0;i<count;i++)
                out.print(printList[i]+" ");
            if(sql[0]!=null) out.print(" Second Chance ");
            for (int i = 0; i < sql.length; i++) {
                if (sql[i] == null)
                    break;
                out.print(sql[i] + " ");
            }
            out.print("\n");


        }

    }

    class Queue<Key extends Comparable<Key>> {

        class qNode {
            Key data;
            int value;
            qNode left, right;

            public qNode(Key item) {
                data = item;
                value = 0;
                left = right = null;
            }
        }

        qNode rear,front;
        int memCount,elemCount,pfc;

        boolean isEmpty(){return elemCount==0;}
        boolean isnotFul(){return memCount>elemCount;}

        Queue(int memory){
            rear=front=null;
            memCount=memory;
            elemCount=pfc=0;
        }

        void printQq(){
            qNode t=front;
            while (t!=null){
                out.print(t.data+" ");
                t=t.right;
            }
            out.print("\n");
        }
        void printpfc(){
            out.print(pfc+"\n");
        }

        void enq(Key elem){
            qNode t = new qNode(elem);
            if(isEmpty())
                rear=front=t;
            else{
                rear.right=t;
                t.left=rear;
                rear=t;
            }
            elemCount++;
        }

        Key deq(){
            Key rr = front.data;
            if(!isEmpty()){
                front=front.right;
                front.left=null;
            }
            return rr;
        }

        void FIFO(Key ele, BST tree,MainMemory mem){

            if(tree.contain(ele))
                out.print("         \t");
            else{
                out.print("Page Fault\t");
                tree.insert(ele);
                pfc++;
                if(isnotFul()) {
                    enq(ele);
                    mem.add(ele);
                }
                else{
                    Key tk=deq();
                    mem.add(tk,ele);
                    tree.deleteKey(tk);
                    enq(ele);
                }
            }
            mem.printFckList();
        }

        void penq(Key elem){
            qNode t = new qNode(elem);
            if(isEmpty())
                rear=front=t;
            else{
                qNode tem = front;
                while(tem != null && elem.compareTo(tem.data)<0)
                    tem=tem.right;
                if(tem==null){
                    rear.right=t;
                    t.left=rear;
                    rear=t;
                }
                else if(tem==front){
                    t.right=front;
                    front.left=t;
                    front=t;
                }
                else{
                    tem.left.right=t;
                    t.left=tem.left;
                    t.right=tem;
                    tem.left=t;
                }
            }
            elemCount++;
        }

        void Priorty(Key ele,BST tree,MainMemory mem){
            if(tree.contain(ele))
                out.print("         \t");
            else{
                out.print("Page Fault\t");
                tree.insert(ele);
                pfc++;
                if(isnotFul()) {
                    penq(ele);
                    mem.add(ele);
                }
                else{
                    Key tk=deq();
                    mem.add(tk,ele);
                    tree.deleteKey(tk);
                    penq(ele);
                }
            }
            mem.printFckList();
        }

        Key[] senq(Key elem,boolean wasHere){

            Key[] k = null;
            int i=0;

            qNode t = front;
            if(wasHere) {
                while (t.data.compareTo(elem)!=0)
                    t=t.right;
                t.value=1;
            }
            else{
                k =(Key[]) new Comparable[memCount];
                while (t.value==1) {
                    k[i++]=t.data;
                    t = t.right;
                    enq(deq());
                }
            }
            return k;
        }

        void SecondChance(Key ele,BST tree,MainMemory mem){

            Key[] tmm=(Key[])new Comparable[memCount];
            if(tree.contain(ele)) {
                senq(ele,true);
                out.print("         \t");
            }
            else{
                out.print("Page Fault\t");
                tree.insert(ele);
                pfc++;
                if(isnotFul()) {
                    enq(ele);
                    mem.add(ele);
                }
                else{
                    tmm=senq(ele,false);
                    Key tk=deq();
                    mem.add(tk,ele);
                    tree.deleteKey(tk);
                    enq(ele);
                }
            }
            mem.printFckList(tmm);
        }



    }

    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve()
    {
        BST<Character> trem = new BST<>();
        MainMemory memoli ;
        Queue<Character> fcq ;


        String t;
        int memer;
        char c;
        String typeOfFckng,mrsCamAgaci;
        ns();memer=ni();
        out.println("Memory "+ memer);
        fcq = new Queue<>(memer);
        memoli = new MainMemory(memer);
        ns();typeOfFckng=ns();
        ns();mrsCamAgaci=ns();
        out.println(typeOfFckng+"Page Replacement");
        out.println("Binary Search Tree");
        t=ns();
        if(typeOfFckng.compareTo("FIFO")==0) {
            out.print("\n");
            while (t.compareTo("") != 0) {
                c = nc();//letter
                fcq.FIFO(c,trem,memoli);
                t = ns();//read
            }
        }
        else if(typeOfFckng.compareTo("SecondChance")==0) {
            while (t.compareTo("") != 0) {
                c = nc();//letter
                fcq.SecondChance(c,trem,memoli);
                t = ns();//read
            }
        }
        else if(typeOfFckng.compareTo("PriorityQueue")==0) {
            while (t.compareTo("") != 0) {
                c = nc();//letter
                fcq.Priorty(c,trem,memoli);
                t = ns();//read
            }
        }

        fcq.printpfc();
    }

    void run(String[] args) throws Exception
    {
        is = INPUT.isEmpty() ? new FileInputStream(args[0]) : new ByteArrayInputStream(INPUT.getBytes());
        char x = args[0].charAt(args[0].length()-5);
        File file = new File("./output"+x+".txt");
        file.getParentFile().mkdir();
        out = new PrintWriter(file);

        long s = System.currentTimeMillis();
        solve();
        out.println(System.currentTimeMillis()-s+"ms");
        out.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }

    public static void main(String[] args) throws Exception { new Assignment2().run(args); }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte()
    {
        //if(lenbuf == -1)throw new InputMismatchException();
        if(lenbuf == -1)System.exit(1);
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private char nc() { return (char)skip(); }

    private String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private void tr(Object... o) { if(INPUT.length() > 0)out.println(Arrays.deepToString(o)); }

}
