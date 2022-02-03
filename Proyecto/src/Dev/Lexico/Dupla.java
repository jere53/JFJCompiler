package Dev.Lexico;

import java.util.Objects;

public class Dupla<F, S> {
    public final F first;
    public final S second;


    public Dupla(F first, S second) {
        this.first = first;
        this.second = second;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dupla)) {
            return false;
        }
        Dupla<?, ?> p = (Dupla<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }


    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }
}
