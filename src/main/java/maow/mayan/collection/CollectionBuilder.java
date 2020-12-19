package maow.mayan.collection;

import java.util.Collection;
import java.util.function.Function;

public interface CollectionBuilder<E> {
    CollectionBuilder<E> add(E e);
    CollectionBuilder<E> addIf(Function<Collection<E>, Boolean> predicate, E e);
    CollectionBuilder<E> remove(E e);
    CollectionBuilder<E> removeIf(Function<Collection<E>, Boolean> predicate, E e);
    Collection<E> build();
}
