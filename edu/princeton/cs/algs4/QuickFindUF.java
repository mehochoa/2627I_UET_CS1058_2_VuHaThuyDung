package princeton.cs.algs4;

public class QuickFindUF {
  private int[] id;

  public QuickFindUF(int n){
    id = new int[n];
    for (int i=0; i<n; i++){
      id[i] = i;
    }
  }

  public int find( int p){
    return id[p];
  }

  public void union(int p, int q){
    int idp = id[p];
    int idq = id[q];

    if (id[p] == id[q]) {
        return ;
    }

    for ( int i = 0; i<id.length; i++) {
      if (id[i] == idp) {
        id[i] = idq;
      }
    }
  }
}

