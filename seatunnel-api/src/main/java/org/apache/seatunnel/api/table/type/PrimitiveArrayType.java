/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.api.table.type;

public class PrimitiveArrayType<T> implements SeaTunnelDataType<T> {
    public static final PrimitiveArrayType<byte[]> PRIMITIVE_BYTE_ARRAY_TYPE =
        new PrimitiveArrayType<>(byte[].class);

    /** The class of the array. */
    private final Class<T> arrayClass;

    private PrimitiveArrayType(Class<T> arrayClass) {
        this.arrayClass = arrayClass;
    }

    @Override
    public Class<T> getTypeClass() {
        return this.arrayClass;
    }

    @Override
    public int hashCode() {
        return arrayClass.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PrimitiveArrayType) {
            PrimitiveArrayType<?> other = (PrimitiveArrayType<?>) obj;
            return arrayClass == other.arrayClass;
        } else {
            return false;
        }
    }
}