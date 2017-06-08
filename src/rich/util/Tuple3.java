package rich.util;

/**
 * Created by Teppei Shiroyama under MIT License.
 */
public class Tuple3<A,B,C> implements Pair<A,Pair<B,C>>{
    final A _1;
    final B _2;
    final C _3;

    public Tuple3(A _1,B _2,C _3){
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
    }

    @Override
    public A getLeft() {
        return _1;
    }
    @Override
    public Pair<B, C> getRight() {
        return new Tuple2<>(_2,_3);
    }
}
