public static void width(Node node,int level, int[] maxMin){
        if(node == null) return;

        maxMin[0] = Math.max(maxMin[0],level);
        maxMin[1] = Math.min(maxMin[1],level);
        
        width(node.left, level-1,maxMin);
        width(node.right, level+1,maxMin);
    }

    public static class pair{

        Node node = null;
        int val = 0;

        pair(Node node,int val){
            this.node = node;
            this.val = val;
        }
    }

    public static List<Integer> leftView(Node node){
        LinkedList<pair> que = new LinkedList<>();
        que.addLast(new pair(node,0));

        int level = 0;
        ArrayList<pair> ans = new ArrayList<>();

        while(que.size()!=0){
            int size = que.size();
            while(size-- > 0){
                pair vtx = que.removeFirst();
                
                if(level == ans.size()) ans.add(vtx);   
                else if(vtx.val < ans.get(level).val) ans.set(level,vtx);

                if(vtx.node.left != null) que.addLast(new pair(vtx.node.left,vtx.val - 1));
                if(vtx.node.right != null) que.addLast(new pair(vtx.node.right,vtx.val + 1));
            
            }

            System.out.println();
            level++;
        }
    }

    
    public static List<Integer> leftViewInterview(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);

        ArrayList<Integer> ans = new ArrayList<>();

        while(que.size()!=0){
            int size = que.size();
            ans.add(que.getFirst.data);
            while(size-- > 0){
                Node vtx = que.removeFirst();
                
                if(vtx.left != null) que.addLast(vtx.left);
                if(vtx.right != null) que.addLast(vtx.right);            
            }
        }

        return ans;
    }

    public static List<Integer> rightView(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);

        ArrayList<Integer> ans = new ArrayList<>();

        while(que.size()!=0){
            int size = que.size();
            int prev = -1;
            while(size-- > 0){
                Node vtx = que.removeFirst();
                
                if(vtx.left != null) que.addLast(vtx.left);
                if(vtx.right != null) que.addLast(vtx.right);            
                
                prev = vtx.data;
            }
            ans.add(prev);
        }

        return ans;
    }

    public static void verticalOrderTraversal(Node node){
        int[] maxMin = new int[2];
        width(node,0,maxMin);

        int n = maxMin[0] - maxMin[1] + 1;
        ArrayList<Inreger>[] ans = new ArrayList[n];
        for(int i=0;i<n;i++) ans[i] = new ArrayList<>();

        LinkedList<pair> que = new LinkedList;
        que.addLast(new pair(node,-maxMin[1]));

        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                pair vtx = que.removeFirst();

                ans[vtx.val].add(ans.node.data);
                if(vtx.node.left!=null) que.addLast(new pair(vtx.node.left,vtx.val - 1));
                if(vtx.node.right!=null) que.addLast(new pair(vtx.node.right,vtx.val + 1));
            }
        }
    }

    public static void verticalSum(Node node){
        int[] maxMin = new int[2];
        width(node,0,maxMin);

        int n = maxMin[0] - maxMin[1] + 1;
        int[] ans = new int[n];
        
        LinkedList<pair> que = new LinkedList;
        que.addLast(new pair(node,-maxMin[1]));

        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                pair vtx = que.removeFirst();

                ans[vtx.val]+=ans.node.data;

                if(vtx.node.left!=null) que.addLast(new pair(vtx.node.left,vtx.val - 1));
                if(vtx.node.right!=null) que.addLast(new pair(vtx.node.right,vtx.val + 1));
            }
        }
    }

    
    public static void bottomSum(Node node){
        int[] maxMin = new int[2];
        width(node,0,maxMin);

        int n = maxMin[0] - maxMin[1] + 1;
        int[] ans = new int[n];
        
        LinkedList<pair> que = new LinkedList;
        que.addLast(new pair(node,-maxMin[1]));

        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                pair vtx = que.removeFirst();

                ans[vtx.val] = ans.node.data;
                
                if(vtx.node.left!=null) que.addLast(new pair(vtx.node.left,vtx.val - 1));
                if(vtx.node.right!=null) que.addLast(new pair(vtx.node.right,vtx.val + 1));
            }
        }
    }

    
    public static void topSum(Node node){
        int[] maxMin = new int[2];
        width(node,0,maxMin);

        int n = maxMin[0] - maxMin[1] + 1;
        Integer[] ans = new Integer[n];
        
        LinkedList<pair> que = new LinkedList;
        que.addLast(new pair(node,-maxMin[1]));

        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                pair vtx = que.removeFirst();
 
                if(ans[vtx.val]==null)
                   ans[vtx.val] = ans.node.val;
                
                if(vtx.node.left!=null) que.addLast(new pair(vtx.node.left,vtx.val - 1));
                if(vtx.node.right!=null) que.addLast(new pair(vtx.node.right,vtx.val + 1));
            }
        }
    }