package rich.util;

/**
 * Created by Teppei Shiroyama under MIT License.
 */
public class Tuple2<A, B> implements Pair<A, B> {
    final A _1;
    final B _2;

    public Tuple2(A _1, B _2) {
        this._1 = _1;
        this._2 = _2;
    }

    @Override
    public A getLeft() {
        return _1;
    }

    @Override
    public B getRight() {
        return _2;
    }
}
