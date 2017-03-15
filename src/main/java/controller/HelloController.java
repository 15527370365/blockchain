package controller;

import com.jfinal.core.Controller;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.util.concurrent.ExecutionException;

/**
 * Created by mac on 2017/3/14.
 */
public class HelloController extends Controller {
    public void index(){
        //http://222.20.138.2:58081/
        Web3j web3j = Web3j.build(new HttpService("http://222.20.138.2:58081/"));
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        renderText("test"+clientVersion);
    }
}
