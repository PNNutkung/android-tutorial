package th.in.pnnutkung.helloworld;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by PNNutkung on 2017-10-18.
 */

public class CustomViewGroup extends BaseViewGroup {
    private Button btnHello;

    public CustomViewGroup(@NonNull Context context) {
        super(context);
        initInstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInstances();
    }

    @RequiresApi(21)
    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInstances();
    }

    private void initInstances() {
        btnHello = findViewById(R.id.btnCustomViewGroup);
    }

    public void setButtonText(String text) {
        btnHello.setText(text);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.sample_layout;
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if( !( state instanceof SavedState ) ){
            super.onRestoreInstanceState( state );
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState( ss );
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        // Must call
        SavedState ss = (SavedState) onSaveChildInstanceState( new SavedState( superState ) );
        // save data here
        return ss;
    }

    private static class SavedState extends ChildSavedState{

        SavedState( Parcelable superState ){
            super( superState );
        }

        private SavedState( Parcel in, ClassLoader classLoader ){
            super( in, classLoader );
            // save data here
        }

        @Override
        public void writeToParcel( Parcel out, int flags ){
            super.writeToParcel( out, flags );
            // restore data here
        }

        public static final ClassLoaderCreator<SavedState> CREATOR = new ClassLoaderCreator<CustomViewGroup.SavedState>(){
            @Override
            public CustomViewGroup.SavedState createFromParcel( Parcel source, ClassLoader loader ){
                return new CustomViewGroup.SavedState( source, loader );
            }

            public CustomViewGroup.SavedState createFromParcel( Parcel in ){
                return null;
            }


            public CustomViewGroup.SavedState[] newArray( int size ){
                return new CustomViewGroup.SavedState[size];
            }
        };
    }
}
