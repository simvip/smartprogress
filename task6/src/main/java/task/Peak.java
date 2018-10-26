package task;

/**
 * Created by Ivan Sliusar on 24.10.2018.
 * Red Line Soft corp.
 */
public class Peak {
    int x;
    int y;
    int layer;

    public Peak(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean BelongThisSet(Peak compareCell) {
        if (this.x == compareCell.x) {
            return Math.abs(this.y - compareCell.y) == 1;
        } else if (this.y == compareCell.y) {
            return Math.abs(this.x - compareCell.x) == 1;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peak cell = (Peak) o;

        if (x != cell.x) return false;
        return y == cell.y;

    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
