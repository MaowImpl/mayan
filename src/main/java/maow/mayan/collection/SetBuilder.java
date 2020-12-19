package maow.mayan.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class SetBuilder<E> implements CollectionBuilder<E> {
    private final Set<E> set;

    public SetBuilder() {
        this.set = new HashSet<>();
    }

    public SetBuilder(Set<E> set) {
        this.set = set;
    }

    @Override
    public CollectionBuilder<E> add(E e) {
        set.add(e);
        return this;
    }

    @Override
    public CollectionBuilder<E> addIf(Function<Collection<E>, Boolean> predicate, E e) {
        if (predicate.apply(set)) {
            set.add(e);
        }
        return this;
    }

    @Override
    public CollectionBuilder<E> remove(E e) {
        set.remove(e);
        return this;
    }

    @Override
    public CollectionBuilder<E> removeIf(Function<Collection<E>, Boolean> predicate, E e) {
        if (predicate.apply(set)) {
            set.remove(e);
        }
        return this;
    }

    @Override
    public Collection<E> build() {
        return set;
    }
}
