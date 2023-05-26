/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passcodederivation;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author tugsbilegkhaliunbat
 */
public class PasscodeDerivation {

    /**
     * @param args the command line arguments
     */
    /*
    public void topologicalSort(int v, boolean visited[], Stack<Integer> stack){
            visited[v] = true;
            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()){
                int adj = i.next();
                if(!visited[adj]){
                    topologicalSort(adj, visited, stack);
                }
            }
            stack.push(v);
        }
        
        public void topologicalSort(){
            Stack<Integer> stack = new Stack<Integer>();
            
            boolean[] visited = new boolean[v];
            for(int i = 0; i < v; i++){
                visited[i] = false;
            }
            for (int i = 0; i < v; i++) {
                if(visited[i] == false){
                    topologicalSort(i, visited, stack);
                }
            }
            while(!stack.empty()){
                System.out.print(stack.pop()+ " ");
            }
        }
    */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph g = new DirectedSparseGraph() {};
        String[] keylog = {"319","680","180","690","129","620","762","689","762","318","368","710","720","710","629","168","160","689","716","731","736","729","316","729","729","710","769","290","719","680","318","389","162","289","162","718","729","319","790","680","890","362","319","760","316","729","380","319","728","716"};
        
        
        Map<Integer, LinkedList<Integer>> map = new HashMap();
        
        
        for(String key: keylog){
            
            for (int i = 0; i < 2; i++) {
            LinkedList edges = new LinkedList();
                int n = Integer.valueOf(key.substring(i, i+1));
                if(!map.containsKey(n)){
                    map.put(n, edges);
                }
                for (int j = i+1; j < i+2; j++) {
                    int m = Integer.valueOf(key.substring(j, j+1));
                    if(!map.get(n).contains(m)){
                        map.get(n).add(m);
                    }
                }
            }
        }
        
        Set vertices = new HashSet();
        for(int key: map.keySet()){
            for(int n : map.get(key)){
                g.addEdge(key+"->"+n,key, n);
                //System.out.println(n+"-"+g.inDegree(n));
                vertices.add(n);
            }
        }
        
        //System.out.println(map);
        //System.out.println(vertices);
        System.out.println(g);
        String answer ="";
        
        while(!map.isEmpty()){
            List toRemove = new ArrayList();
            Iterator<Integer> i = g.getVertices().iterator();
            while(i.hasNext()){
                int v = i.next();
                if(g.inDegree(v) == 0){
                    toRemove.add(v);
                }
            }
            g.removeVertex(toRemove.get(0));
            map.remove(toRemove.get(0));
            answer+=toRemove.get(0)+"";
            System.out.println(g);
            System.out.println("");
        }
        
        answer+=g.getVertices().toArray()[0]+"";
        
        System.out.print("Keylog: ");
        for(String key:keylog){
            System.out.print(key+", ");
        }
        System.out.println("");
        System.out.println("The shortest possible passcode: "+answer);
        
        
        
        
        
        
    }
    
}
