package com.example.lenovo.expandablelistview;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class VerifyPassenger extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6102bb8061001e6000396000f30060606040526004361061006c5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166303446b188114610071578063080b2a861461009e57806350b44712146100c35780637dc379fa146100f1578063b03f07de14610107575b600080fd5b341561007c57600080fd5b61008a600435602435610120565b604051901515815260200160405180910390f35b34156100a957600080fd5b6100b161014d565b60405190815260200160405180910390f35b34156100ce57600080fd5b6100d9600435610154565b60405191825260208201526040908101905180910390f35b34156100fc57600080fd5b6100d9600435610180565b341561011257600080fd5b6100b16004356024356101ce565b60008160008481548110151561013257fe5b90600052602060002090600202016000015414905092915050565b6000545b90565b600080548290811061016257fe5b60009182526020909120600290910201805460019091015490915082565b60008060008381548110151561019257fe5b9060005260206000209060020201600001546000848154811015156101b357fe5b90600052602060002090600202016001015491509150915091565b600080546101df826001830161023a565b506000805484919060001981019081106101f557fe5b600091825260208220600290910201919091558054839190600019810190811061021b57fe5b6000918252602082206001600290920201019190915554905092915050565b81548183558181151161026657600202816002028360005260206000209182019101610266919061026b565b505050565b61015191905b8082111561028b5760008082556001820155600201610271565b50905600a165627a7a723058202c516b67f0791702142419f93d24037e31d306dd981d4d64dedc53d091e14c100029";

    protected VerifyPassenger(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VerifyPassenger(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Boolean> verifyTicket(BigInteger index, BigInteger pnr) {
        Function function = new Function("verifyTicket",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index),
                        new org.web3j.abi.datatypes.generated.Uint256(pnr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> getTicketsCount() {
        Function function = new Function("getTicketsCount",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> tickets(BigInteger param0) {
        final Function function = new Function("tickets",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> getTicket(BigInteger index) {
        final Function function = new Function("getTicket",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addTicket(BigInteger _pnr, BigInteger _aadhar_no) {
        Function function = new Function(
                "addTicket",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_pnr),
                        new org.web3j.abi.datatypes.generated.Uint256(_aadhar_no)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<VerifyPassenger> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VerifyPassenger.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<VerifyPassenger> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VerifyPassenger.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static VerifyPassenger load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VerifyPassenger(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static VerifyPassenger load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VerifyPassenger(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}