package com.keba.kemro.plc.network.sysrpc.TCI;

import com.keba.jrpc.rpc.*;
import java.io.*;

public class SysRpcTcGetExeUnitInfoListIn implements XDR {
	public int nrOfExeUnitHnd;
	public int[] exeUnitHnd;  //variable length with max length of TCI.rpcChunkLen
	public int exeUnitHnd_count; //countains the number of elements

	public SysRpcTcGetExeUnitInfoListIn () {
		exeUnitHnd = new int[TCI.rpcChunkLen];
	}

	public void write (RPCOutputStream out) throws RPCException, IOException {
		out.writeInt(nrOfExeUnitHnd);
		out.writeInt(exeUnitHnd_count);
		for (int for_i = 0; for_i < exeUnitHnd_count; for_i++) {
			out.writeInt(exeUnitHnd[for_i]);
		}
	}

	public void read (RPCInputStream in) throws RPCException, IOException {
		nrOfExeUnitHnd = in.readInt();
		exeUnitHnd_count = in.readInt();
		for (int for_i = 0; for_i < exeUnitHnd_count; for_i++) {
			exeUnitHnd[for_i] = in.readInt();
		}
	}
}