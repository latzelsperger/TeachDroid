package com.keba.kemro.plc.network.sysrpc.RepSys;

import java.io.IOException;

import com.keba.jrpc.rpc.RPCException;
import com.keba.jrpc.rpc.RPCInputStream;
import com.keba.jrpc.rpc.RPCOutputStream;
import com.keba.jrpc.rpc.XDR;

public class TRepSysNr implements XDR {
	public int mClassId;
	public int mCompId;
	public int mMsgId;
	public int mInstId;

	public TRepSysNr () {
	}

	public void write (RPCOutputStream out) throws RPCException, IOException {
		out.writeInt(mClassId);
		out.writeInt(mCompId);
		out.writeInt(mMsgId);
		out.writeInt(mInstId);
	}

	public void read (RPCInputStream in) throws RPCException, IOException {
		mClassId = in.readInt();
		mCompId = in.readInt();
		mMsgId = in.readInt();
		mInstId = in.readInt();
	}
}