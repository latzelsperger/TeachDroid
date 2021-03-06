package com.keba.kemro.plc.network.sysrpc.TCI;

import com.keba.jrpc.rpc.*;
import java.io.*;

public class SysRpcTcExecInfoElem implements XDR {
	public String infoText;
	public int infoValue1;
	public int infoValue2;

	public SysRpcTcExecInfoElem () {
	}

	public void write (RPCOutputStream out) throws RPCException, IOException {
		out.writeString(infoText);
		out.writeInt(infoValue1);
		out.writeInt(infoValue2);
	}

	public void read (RPCInputStream in) throws RPCException, IOException {
		infoText = in.readString();
		infoValue1 = in.readInt();
		infoValue2 = in.readInt();
	}
}