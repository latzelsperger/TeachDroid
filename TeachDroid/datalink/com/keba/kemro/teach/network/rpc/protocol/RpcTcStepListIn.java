package com.keba.kemro.teach.network.rpc.protocol;

import com.keba.jrpc.rpc.*;
import java.io.*;

public class RpcTcStepListIn implements XDR {
	public int nrOfExeUnitHnd;
	public int[] exeUnitHnd;  //variable length with max length of rpcChunkLen
	public int exeUnitHnd_count; //countains the number of elements
	public RpcTcExeStepState stepCmd;

	public RpcTcStepListIn () {
		exeUnitHnd = new int[rpcChunkLen.value];
		stepCmd = new RpcTcExeStepState();
	}

	public void write (RPCOutputStream out) throws RPCException, IOException {
		out.writeInt(nrOfExeUnitHnd);
		out.writeInt(exeUnitHnd_count);
		for (int for_i = 0; for_i < exeUnitHnd_count; for_i++) {
			out.writeInt(exeUnitHnd[for_i]);
		}
		stepCmd.write(out);
	}

	public void read (RPCInputStream in) throws RPCException, IOException {
		nrOfExeUnitHnd = in.readInt();
		exeUnitHnd_count = in.readInt();
		for (int for_i = 0; for_i < exeUnitHnd_count; for_i++) {
			exeUnitHnd[for_i] = in.readInt();
		}
		stepCmd.read(in);
	}
}