/*
 *  Copyright 2008 biaoping.yin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.frameworkset.spi.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodProxy;

import org.frameworkset.spi.CallContext;
import org.frameworkset.spi.assemble.BaseTXManager;
import org.frameworkset.spi.remote.ServiceID;

/**
 * <p>Title: CGLibProxy.java</p> 
 * <p>Description: </p>
 * <p>bboss workgroup</p>
 * <p>Copyright (c) 2007</p>
 * @Date 2010-6-19 ����06:00:58
 * @author biaoping.yin
 * @version 1.0
 */
public class CGLibProxy extends BaseCGLibProxy{

	

	public CGLibProxy(Object delegate,CallContext callcontext, ServiceID serviceID,
			BaseTXManager providerManagerInfo) {
		super(delegate,providerManagerInfo,
				serviceID, callcontext); 
	}

	public Object intercept(Object delegate, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		return CGLibUtil.invoke(this.delegate, method, args, proxy, callcontext, serviceID, providerManagerInfo);
	}

}
