package com.example.lenovo.expandablelistview;

import android.net.Credentials;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import java.math.BigInteger;

public class Web3jDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web3j_demo);
        Web3j web3 = Web3jFactory.build(new HttpService());
        String walletId = "801254e62eacc68145812353f4779a69d29fa369";
        String walletSource = "/Users/utkarsh/Downloads/cryp/ethdata/miner1/keystore/UTC--2018-02-22T08-03-01.645776060Z--"
                + walletId + "" + ".json";

        boolean onVerify = false;
        try {
           org.web3j.crypto.Credentials credentials=WalletUtils.loadCredentials("122333", walletSource);

        VerifyPassenger contract;
        TransactionReceipt transactionReceipt;

        try {
            contract = VerifyPassenger
                    .deploy(web3, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT)
                    .send();
            transactionReceipt = contract.addTicket(BigInteger.valueOf(123), BigInteger.valueOf(123))
                    .send();
            System.out.println(transactionReceipt.getTransactionHash());
        } catch (Exception e) {
            //TODO: handle exception
        }}catch (Exception e){}

    }
}
