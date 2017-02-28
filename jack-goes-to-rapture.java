https://www.hackerrank.com/challenges/jack-goes-to-rapture

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String[] line = br.readLine().split(" ");
    final int N = Integer.parseInt(line[0]);
    
    final List<List<Connection>> stations = new ArrayList<List<Connection>>(N);
    for(int i = 0; i++ < N; stations.add(new ArrayList<Connection>())){}
    
    for(int E = Integer.parseInt(line[1]); E > 0; --E){
      line = br.readLine().split(" ");
      final int A = Integer.parseInt(line[0]) - 1;
      final int B = Integer.parseInt(line[1]) - 1;
      final int C = Integer.parseInt(line[2]);
      final Connection connection = new Connection(A, B, C);
      stations.get(A).add(connection);
      stations.get(B).add(connection);
    }
    
    br.close();
    br = null;
    
    final int minFare = getMinFare(stations, 0, N-1);
    System.out.println((minFare < 0) ? "NO PATH EXISTS" : minFare);
  }

  private static int getMinFare(final List<List<Connection>> stations, final int origin, final int destination){
    
    final int N = stations.size();
    final int[] minFares = new int[N];
    for(int i = 0, c = Integer.MAX_VALUE; i < N; minFares[i++] = c){}

    final Queue<Pair<Integer, Integer>> q = new PriorityQueue<Pair<Integer, Integer>>(N);
    minFares[origin] = 0;
    q.add(new Pair<Integer, Integer>(origin, 0));
    do {
      
      final int stationId = q.poll().key;
      final int curFare = minFares[stationId];
      
      if(stationId == destination){
        return curFare;
      }
      
      for(Connection connection : stations.get(stationId)){
        final int connectingStationId = connection.getStationId(stationId);
        final int minFare = minFares[connectingStationId];
        final int newMinFare = Math.max(curFare, connection.fare);
        if(minFare > newMinFare){
          minFares[connectingStationId] = newMinFare;
          q.add(new Pair<Integer, Integer>(connectingStationId, newMinFare));
        }
      }
    } while (!q.isEmpty());
    
    return -1;
  }
  
  private static class Pair<K, V extends Comparable<V>> implements Comparable<Pair<K, V>>{
    public final K key;
    public final V value;
    
    public Pair(final K key, final V value){
      this.key = key;
      this.value = value;
    }
    
    public int compareTo(Pair<K, V> b){
      return this.value.compareTo(b.value);
    }
  }
  
  private static class Connection {
    public final int fare;
    public final int stationIds;
    
    public Connection(final int stationId1, final int stationId2, final int fare){
      this.fare = fare;
      this.stationIds = stationId1 ^ stationId2;
    }
    
    public int getStationId(final int stationId){
      return stationIds ^ stationId;
    }
  }
}
