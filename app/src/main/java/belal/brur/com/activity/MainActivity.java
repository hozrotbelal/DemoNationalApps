package belal.brur.com.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import belal.brur.com.ApiUtilities.BaseApiService;
import belal.brur.com.ApiUtilities.UtilsApi;
import belal.brur.com.R;
import belal.brur.com.adapter.ContentFileListAdapter;
import belal.brur.com.model.GetContentFileListResp;
import belal.brur.com.model.ParamAppUser;
import belal.brur.com.network.NetworkManager;
import belal.brur.com.utils.Tools;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /**------------------------------------------------------------------------------------------------
     * Start Block - Private Variables
     **------------------------------------------------------------------------------------------------*/
    Context context;
    private Toolbar toolbar;
    private TextView txttoolbar;
    private TextView txtNoData;
    private ImageView iv_back;
    private RecyclerView recyclerView;
    private ContentFileListAdapter contentFileListAdapter;
    //Background service
    BaseApiService mApiService;
    // loading
    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        mApiService = UtilsApi.getOthersAPIService();
        context = this;
        // Setup ToolBar
        initToolBarSetUp();
        //initialize user interface
        initUI();

    }

    /**------------------------------------------------------------------------------------------------
     * Start Block -  initToolBarSetUp Methods
     **------------------------------------------------------------------------------------------------*/

    private void initToolBarSetUp() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txttoolbar = (TextView) toolbar.findViewById(R.id.txttoolbar);
        txttoolbar.setText( "Content List" );
        iv_back = (ImageView) findViewById( R.id.iv_back );
        iv_back.setOnClickListener( this );
    }
    /*------------------------------------------------------------------------------------------------
     * End Block -  initToolBarSetUp Methods
     **------------------------------------------------------------------------------------------------*/

    /**------------------------------------------------------------------------------------------------
     * Start Block - Init UI Methods
     **------------------------------------------------------------------------------------------------*/

    private void initUI() {

        txtNoData = (TextView)findViewById( R.id.txt_no_data );

        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
        recyclerView.setLayoutManager(new GridLayoutManager(this, Tools.getGridSpanCount(this)));
        recyclerView.setHasFixedSize(true);
        //set data and list adapter
        contentFileListAdapter = new ContentFileListAdapter(getApplicationContext());

        if (NetworkManager.isInternetAvailable(context)){
            requestContentFileList();
        }
        else{
            Toast.makeText( context, getResources().getString( R.string.internet_error_msg ), Toast.LENGTH_SHORT ).show();
        }
    }

    /*------------------------------------------------------------------------------------------------
     * End Block - Init UI Methods
     **------------------------------------------------------------------------------------------------*/


    /**------------------------------------------------------------------------------------------------
     * Start Block - Override Methods
     **------------------------------------------------------------------------------------------------*/
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
    /*------------------------------------------------------------------------------------------------
     * End Block - Override Methods
     **------------------------------------------------------------------------------------------------*/

    /**------------------------------------------------------------------------------------------------
     * Start Block -  requestContentFileList Methods
     **------------------------------------------------------------------------------------------------*/

    private void requestContentFileList() {

        ParamAppUser paramAppUser = new ParamAppUser( "9", "35" );
        Log.e( "paramAppUser",paramAppUser.toString()+">>" );
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..., Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        mApiService.pContentFileListRequest(paramAppUser)
                .enqueue(new Callback<GetContentFileListResp>() {
                    @Override
                    public void onResponse(Call<GetContentFileListResp> call, Response<GetContentFileListResp> response) {

                        if (response != null && response.isSuccessful()) {
                            progressDialog.dismiss();
                            GetContentFileListResp getContentFileListResp = response.body();

                            if (getContentFileListResp != null ) {
                                Log.e( "GetContentFileListResp",getContentFileListResp.toString()+"" );
                                if (getContentFileListResp.getContentfilelist()!=null){
                                    recyclerView.setVisibility( View.VISIBLE );
                                    contentFileListAdapter.addAll(getContentFileListResp.getContentfilelist());
                                    recyclerView.setAdapter(contentFileListAdapter);
                                    contentFileListAdapter.notifyDataSetChanged();
                                } else {
                                    recyclerView.setVisibility( View.GONE );
                                    txtNoData.setVisibility( View.VISIBLE );
                                    txtNoData.setText( "No Data Found" );
                                }

                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_no_info_found), Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_could_not_retrieve_info), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<GetContentFileListResp> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        progressDialog.dismiss();
                    }
                });
    }


}
