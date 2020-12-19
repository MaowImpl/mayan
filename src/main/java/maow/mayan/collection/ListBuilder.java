package maow.mayan.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class ListBuilder<E> implements CollectionBuilder<E> {
    private final List<E> list;

    public ListBuilder() {
        this.list = new ArrayList<>();
    }

    public ListBuilder(List<E> list) {
        this.list = list;
    }

    @Override
    public ListBuilder<E> add(E e) {
        list.add(e);
        return this;
    }

    @Override
    public CollectionBuilder<E> addIf(Function<Collection<E>, Boolean> predicate, E e) {
        if (predicate.apply(list)) {
            list.add(e);
        }
        return this;
    }

    @Override
    public ListBuilder<E> remove(E e) {
        list.remove(e);
        return this;
    }

    @Override
    public CollectionBuilder<E> removeIf(Function<Collection<E>, Boolean> predicate, E e) {
        if (predicate.apply(list)) {
            list.remove(e);
        }
        return this;
    }

    @Override
    public List<E> build() {
        return list;
    }
}
