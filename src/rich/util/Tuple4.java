package rich.util;

/**
 * Created by Teppei Shiroyama under MIT License.
 */
public class Tuple4<A,B,C,D> implements Pair<A,Pair<B,Pair<C,D>>>{
    final A _1;
    final B _2;
    final C _3;
    final D _4;

    public Tuple4(A _1,B _2,C _3,D _4){
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
    }
    @Override
    public A getLeft() {
        return _1;
    }

    @Override
    public Pair<B, Pair<C, D>> getRight() {
        return new Tuple3<>(_2,_3,_4);
    }
}
