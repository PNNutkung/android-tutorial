package th.in.pnnutkung.helloworld;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View.BaseSavedState;

/**
 * Created by PNNutkung on 2017-10-29.
 */

public class CustomViewSavedState extends BaseSavedState {
    private boolean blue;

    public CustomViewSavedState(Parcel source) {
        super(source);
        // read back
        blue = source.readInt() == 1;
    }

    public CustomViewSavedState(Parcelable superState) {
        super(superState);
    }

    public boolean isBlue() {
        return blue;
    }

    public void setBlue(boolean blue) {
        this.blue = blue;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        // Write var here
        out.writeInt(blue ? 1 : 0);
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel parcel) {
            return new CustomViewSavedState(parcel);
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[size];
        }
    };
}
