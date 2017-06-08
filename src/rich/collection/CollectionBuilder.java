package rich.collection;

/**
 * Created by Teppei Shiroyama under MIT License.
 */
public interface CollectionBuilder<T,CollectionType extends Collection<T,CollectionType>> {
    CollectionBuilder<T,CollectionType> add(T t);
    CollectionBuilder<T,CollectionType> addAll(Collection<T,?> collection);
    CollectionBuilder<T,CollectionType> remove(T t);
    CollectionType build();
}
