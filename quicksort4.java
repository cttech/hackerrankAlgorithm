import java.util.*;

class Solution
{
 static int swap = 0 , shift = 0 ;
 
 static int partition( int a[] , int start , int end)
 {
  int item = a[end] , p = start , temp ;
  for( int i = start ; i < end ; i++ )
  {
   if( a[i] <= item )
   { 
    temp = a[i] ;
    a[i] = a[p] ;
    a[p] = temp ;
    p++;
    swap++ ;
   }
   
  }
  a[end] = a[p] ;
  a[p] = item ;
  swap++ ;
  return p ;
 }
 
 static void Quick( int q[] , int start , int end )
 {
  if( start < end )
  {
   int j = partition( q , start , end ) ;
   Quick( q , start , j - 1 ) ;
   Quick( q , j + 1 , end ) ;
  }
 }
 
 
 static void insertion( int a[] , int size )
 {
  for( int u = 1 ; u < size ; u++ )
  {
   int j = u - 1 , item = a[u] ;
   while( j >= 0 && a[j] > item )
   {
    a[j+1] = a[j] ;
    j--;
    shift++ ;
   }
    a[j+1] = item ;
   
  }
 }
 public static void main( String ...$ )
 {
  Scanner in = new Scanner( System.in ) ;
  int n = in.nextInt();
  int ar[] = new int[n] ;
  int ar1[] = new int[n] ;
    
  for( int i = 0 ; i < n ; i++ )
   {
    ar[i] = in.nextInt();
    ar1[i] = ar[i] ;
   }
  
                Quick( ar , 0 , n - 1) ;
  insertion( ar1 , n ) ;
 
  System.out.println(shift-swap);
  in.close();
 }
}
