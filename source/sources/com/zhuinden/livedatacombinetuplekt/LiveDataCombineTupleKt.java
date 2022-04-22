package com.zhuinden.livedatacombinetuplekt;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.zhuinden.tupleskt.Tuple10;
import com.zhuinden.tupleskt.Tuple11;
import com.zhuinden.tupleskt.Tuple12;
import com.zhuinden.tupleskt.Tuple13;
import com.zhuinden.tupleskt.Tuple14;
import com.zhuinden.tupleskt.Tuple15;
import com.zhuinden.tupleskt.Tuple16;
import com.zhuinden.tupleskt.Tuple4;
import com.zhuinden.tupleskt.Tuple5;
import com.zhuinden.tupleskt.Tuple6;
import com.zhuinden.tupleskt.Tuple7;
import com.zhuinden.tupleskt.Tuple8;
import com.zhuinden.tupleskt.Tuple9;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\u001a`\u0010\u0000\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b0\u00070\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\u001a|\u0010\u0000\u001a(\u0012$\u0012\"\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\n0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\u001a\u0001\u0010\u0000\u001a0\u0012,\u0012*\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\r0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0001\u001a´\u0001\u0010\u0000\u001a8\u00124\u00122\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00100\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u00112\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0001\u001aÐ\u0001\u0010\u0000\u001a@\u0012<\u0012:\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u00140\u00130\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u00142\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0001\u001aì\u0001\u0010\u0000\u001aH\u0012D\u0012B\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u00170\u00160\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u0014\"\u0004\b\u0007\u0010\u00172\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0001\u001a\u0002\u0010\u0000\u001aP\u0012L\u0012J\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u001a0\u00190\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u0014\"\u0004\b\u0007\u0010\u0017\"\u0004\b\b\u0010\u001a2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0001\u001a¤\u0002\u0010\u0000\u001aX\u0012T\u0012R\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u001d0\u001c0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u0014\"\u0004\b\u0007\u0010\u0017\"\u0004\b\b\u0010\u001a\"\u0004\b\t\u0010\u001d2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0001\u001aÀ\u0002\u0010\u0000\u001a`\u0012\\\u0012Z\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H 0\u001f0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u0014\"\u0004\b\u0007\u0010\u0017\"\u0004\b\b\u0010\u001a\"\u0004\b\t\u0010\u001d\"\u0004\b\n\u0010 2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u0001\u001aÜ\u0002\u0010\u0000\u001ah\u0012d\u0012b\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H \u0012\u0006\u0012\u0004\u0018\u0001H#0\"0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u0014\"\u0004\b\u0007\u0010\u0017\"\u0004\b\b\u0010\u001a\"\u0004\b\t\u0010\u001d\"\u0004\b\n\u0010 \"\u0004\b\u000b\u0010#2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0\u0001\u001aø\u0002\u0010\u0000\u001ap\u0012l\u0012j\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H \u0012\u0006\u0012\u0004\u0018\u0001H#\u0012\u0006\u0012\u0004\u0018\u0001H&0%0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u0014\"\u0004\b\u0007\u0010\u0017\"\u0004\b\b\u0010\u001a\"\u0004\b\t\u0010\u001d\"\u0004\b\n\u0010 \"\u0004\b\u000b\u0010#\"\u0004\b\f\u0010&2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0\u0001\u001a\u0003\u0010\u0000\u001ax\u0012t\u0012r\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H \u0012\u0006\u0012\u0004\u0018\u0001H#\u0012\u0006\u0012\u0004\u0018\u0001H&\u0012\u0006\u0012\u0004\u0018\u0001H)0(0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u0014\"\u0004\b\u0007\u0010\u0017\"\u0004\b\b\u0010\u001a\"\u0004\b\t\u0010\u001d\"\u0004\b\n\u0010 \"\u0004\b\u000b\u0010#\"\u0004\b\f\u0010&\"\u0004\b\r\u0010)2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0\u0001\u001a±\u0003\u0010\u0000\u001a\u0001\u0012|\u0012z\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H \u0012\u0006\u0012\u0004\u0018\u0001H#\u0012\u0006\u0012\u0004\u0018\u0001H&\u0012\u0006\u0012\u0004\u0018\u0001H)\u0012\u0006\u0012\u0004\u0018\u0001H,0+0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u0014\"\u0004\b\u0007\u0010\u0017\"\u0004\b\b\u0010\u001a\"\u0004\b\t\u0010\u001d\"\u0004\b\n\u0010 \"\u0004\b\u000b\u0010#\"\u0004\b\f\u0010&\"\u0004\b\r\u0010)\"\u0004\b\u000e\u0010,2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0\u0001\u001aÏ\u0003\u0010\u0000\u001a\u0001\u0012\u0001\u0012\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0006\u0012\u0004\u0018\u0001H\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H \u0012\u0006\u0012\u0004\u0018\u0001H#\u0012\u0006\u0012\u0004\u0018\u0001H&\u0012\u0006\u0012\u0004\u0018\u0001H)\u0012\u0006\u0012\u0004\u0018\u0001H,\u0012\u0006\u0012\u0004\u0018\u0001H/0.0\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\u000b\"\u0004\b\u0004\u0010\u000e\"\u0004\b\u0005\u0010\u0011\"\u0004\b\u0006\u0010\u0014\"\u0004\b\u0007\u0010\u0017\"\u0004\b\b\u0010\u001a\"\u0004\b\t\u0010\u001d\"\u0004\b\n\u0010 \"\u0004\b\u000b\u0010#\"\u0004\b\f\u0010&\"\u0004\b\r\u0010)\"\u0004\b\u000e\u0010,\"\u0004\b\u000f\u0010/2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/0\u0001¨\u00061"}, mo26107d2 = {"combineTuple", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "T1", "T2", "f1", "f2", "Lkotlin/Triple;", "T3", "f3", "Lcom/zhuinden/tupleskt/Tuple4;", "T4", "f4", "Lcom/zhuinden/tupleskt/Tuple5;", "T5", "f5", "Lcom/zhuinden/tupleskt/Tuple6;", "T6", "f6", "Lcom/zhuinden/tupleskt/Tuple7;", "T7", "f7", "Lcom/zhuinden/tupleskt/Tuple8;", "T8", "f8", "Lcom/zhuinden/tupleskt/Tuple9;", "T9", "f9", "Lcom/zhuinden/tupleskt/Tuple10;", "T10", "f10", "Lcom/zhuinden/tupleskt/Tuple11;", "T11", "f11", "Lcom/zhuinden/tupleskt/Tuple12;", "T12", "f12", "Lcom/zhuinden/tupleskt/Tuple13;", "T13", "f13", "Lcom/zhuinden/tupleskt/Tuple14;", "T14", "f14", "Lcom/zhuinden/tupleskt/Tuple15;", "T15", "f15", "Lcom/zhuinden/tupleskt/Tuple16;", "T16", "f16", "livedata-combinetuple-kt_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTuple.kt */
public final class LiveDataCombineTupleKt {
    public static final <T1, T2> LiveData<Pair<T1, T2>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.setValue(new Pair(liveData.getValue(), liveData2.getValue()));
        mediatorLiveData.addSource(liveData, new LiveDataCombineTupleKt$combineTuple$1$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleKt$combineTuple$1$2(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3> LiveData<Triple<T1, T2, T3>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        Intrinsics.checkNotNullParameter(liveData3, "f3");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.setValue(new Triple(liveData.getValue(), liveData2.getValue(), liveData3.getValue()));
        mediatorLiveData.addSource(liveData, new LiveDataCombineTupleKt$combineTuple$2$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleKt$combineTuple$2$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData3, new LiveDataCombineTupleKt$combineTuple$2$3(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4> LiveData<Tuple4<T1, T2, T3, T4>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        Intrinsics.checkNotNullParameter(liveData3, "f3");
        Intrinsics.checkNotNullParameter(liveData4, "f4");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.setValue(new Tuple4(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue()));
        mediatorLiveData.addSource(liveData, new LiveDataCombineTupleKt$combineTuple$3$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleKt$combineTuple$3$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData3, new LiveDataCombineTupleKt$combineTuple$3$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData4, new LiveDataCombineTupleKt$combineTuple$3$4(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5> LiveData<Tuple5<T1, T2, T3, T4, T5>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        Intrinsics.checkNotNullParameter(liveData3, "f3");
        Intrinsics.checkNotNullParameter(liveData4, "f4");
        Intrinsics.checkNotNullParameter(liveData5, "f5");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.setValue(new Tuple5(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue()));
        mediatorLiveData.addSource(liveData, new LiveDataCombineTupleKt$combineTuple$4$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleKt$combineTuple$4$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData3, new LiveDataCombineTupleKt$combineTuple$4$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData4, new LiveDataCombineTupleKt$combineTuple$4$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData5, new LiveDataCombineTupleKt$combineTuple$4$5(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6> LiveData<Tuple6<T1, T2, T3, T4, T5, T6>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        Intrinsics.checkNotNullParameter(liveData3, "f3");
        Intrinsics.checkNotNullParameter(liveData4, "f4");
        Intrinsics.checkNotNullParameter(liveData5, "f5");
        Intrinsics.checkNotNullParameter(liveData6, "f6");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.setValue(new Tuple6(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue()));
        mediatorLiveData.addSource(liveData, new LiveDataCombineTupleKt$combineTuple$5$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleKt$combineTuple$5$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData3, new LiveDataCombineTupleKt$combineTuple$5$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData4, new LiveDataCombineTupleKt$combineTuple$5$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData5, new LiveDataCombineTupleKt$combineTuple$5$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData6, new LiveDataCombineTupleKt$combineTuple$5$6(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7> LiveData<Tuple7<T1, T2, T3, T4, T5, T6, T7>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7) {
        LiveData<T1> liveData8 = liveData;
        LiveData<T2> liveData9 = liveData2;
        LiveData<T3> liveData10 = liveData3;
        LiveData<T4> liveData11 = liveData4;
        LiveData<T5> liveData12 = liveData5;
        LiveData<T6> liveData13 = liveData6;
        Intrinsics.checkNotNullParameter(liveData8, "f1");
        Intrinsics.checkNotNullParameter(liveData9, "f2");
        Intrinsics.checkNotNullParameter(liveData10, "f3");
        Intrinsics.checkNotNullParameter(liveData11, "f4");
        Intrinsics.checkNotNullParameter(liveData12, "f5");
        Intrinsics.checkNotNullParameter(liveData13, "f6");
        Intrinsics.checkNotNullParameter(liveData7, "f7");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Tuple7 tuple7 = r8;
        Tuple7 tuple72 = new Tuple7(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue());
        mediatorLiveData.setValue(tuple7);
        mediatorLiveData.addSource(liveData8, new LiveDataCombineTupleKt$combineTuple$6$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData9, new LiveDataCombineTupleKt$combineTuple$6$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData10, new LiveDataCombineTupleKt$combineTuple$6$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData11, new LiveDataCombineTupleKt$combineTuple$6$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleKt$combineTuple$6$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleKt$combineTuple$6$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData7, new LiveDataCombineTupleKt$combineTuple$6$7(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8> LiveData<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8) {
        LiveData<T1> liveData9 = liveData;
        LiveData<T2> liveData10 = liveData2;
        LiveData<T3> liveData11 = liveData3;
        LiveData<T4> liveData12 = liveData4;
        LiveData<T5> liveData13 = liveData5;
        LiveData<T6> liveData14 = liveData6;
        LiveData<T7> liveData15 = liveData7;
        Intrinsics.checkNotNullParameter(liveData9, "f1");
        Intrinsics.checkNotNullParameter(liveData10, "f2");
        Intrinsics.checkNotNullParameter(liveData11, "f3");
        Intrinsics.checkNotNullParameter(liveData12, "f4");
        Intrinsics.checkNotNullParameter(liveData13, "f5");
        Intrinsics.checkNotNullParameter(liveData14, "f6");
        Intrinsics.checkNotNullParameter(liveData15, "f7");
        Intrinsics.checkNotNullParameter(liveData8, "f8");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Tuple8 tuple8 = r9;
        Tuple8 tuple82 = new Tuple8(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue(), liveData8.getValue());
        mediatorLiveData.setValue(tuple8);
        mediatorLiveData.addSource(liveData9, new LiveDataCombineTupleKt$combineTuple$7$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData10, new LiveDataCombineTupleKt$combineTuple$7$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData11, new LiveDataCombineTupleKt$combineTuple$7$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleKt$combineTuple$7$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleKt$combineTuple$7$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleKt$combineTuple$7$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleKt$combineTuple$7$7(mediatorLiveData));
        mediatorLiveData.addSource(liveData8, new LiveDataCombineTupleKt$combineTuple$7$8(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9> LiveData<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9) {
        LiveData<T1> liveData10 = liveData;
        LiveData<T2> liveData11 = liveData2;
        LiveData<T3> liveData12 = liveData3;
        LiveData<T4> liveData13 = liveData4;
        LiveData<T5> liveData14 = liveData5;
        LiveData<T6> liveData15 = liveData6;
        LiveData<T7> liveData16 = liveData7;
        LiveData<T8> liveData17 = liveData8;
        Intrinsics.checkNotNullParameter(liveData10, "f1");
        Intrinsics.checkNotNullParameter(liveData11, "f2");
        Intrinsics.checkNotNullParameter(liveData12, "f3");
        Intrinsics.checkNotNullParameter(liveData13, "f4");
        Intrinsics.checkNotNullParameter(liveData14, "f5");
        Intrinsics.checkNotNullParameter(liveData15, "f6");
        Intrinsics.checkNotNullParameter(liveData16, "f7");
        Intrinsics.checkNotNullParameter(liveData17, "f8");
        Intrinsics.checkNotNullParameter(liveData9, "f9");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Tuple9 tuple9 = r10;
        Tuple9 tuple92 = new Tuple9(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue(), liveData8.getValue(), liveData9.getValue());
        mediatorLiveData.setValue(tuple9);
        mediatorLiveData.addSource(liveData10, new LiveDataCombineTupleKt$combineTuple$8$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData11, new LiveDataCombineTupleKt$combineTuple$8$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleKt$combineTuple$8$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleKt$combineTuple$8$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleKt$combineTuple$8$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleKt$combineTuple$8$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleKt$combineTuple$8$7(mediatorLiveData));
        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleKt$combineTuple$8$8(mediatorLiveData));
        mediatorLiveData.addSource(liveData9, new LiveDataCombineTupleKt$combineTuple$8$9(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> LiveData<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10) {
        LiveData<T1> liveData11 = liveData;
        LiveData<T2> liveData12 = liveData2;
        LiveData<T3> liveData13 = liveData3;
        LiveData<T4> liveData14 = liveData4;
        LiveData<T5> liveData15 = liveData5;
        LiveData<T6> liveData16 = liveData6;
        LiveData<T7> liveData17 = liveData7;
        LiveData<T8> liveData18 = liveData8;
        LiveData<T9> liveData19 = liveData9;
        Intrinsics.checkNotNullParameter(liveData11, "f1");
        Intrinsics.checkNotNullParameter(liveData12, "f2");
        Intrinsics.checkNotNullParameter(liveData13, "f3");
        Intrinsics.checkNotNullParameter(liveData14, "f4");
        Intrinsics.checkNotNullParameter(liveData15, "f5");
        Intrinsics.checkNotNullParameter(liveData16, "f6");
        Intrinsics.checkNotNullParameter(liveData17, "f7");
        Intrinsics.checkNotNullParameter(liveData18, "f8");
        Intrinsics.checkNotNullParameter(liveData19, "f9");
        Intrinsics.checkNotNullParameter(liveData10, "f10");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Tuple10 tuple10 = r11;
        Tuple10 tuple102 = new Tuple10(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue(), liveData8.getValue(), liveData9.getValue(), liveData10.getValue());
        mediatorLiveData.setValue(tuple10);
        mediatorLiveData.addSource(liveData11, new LiveDataCombineTupleKt$combineTuple$9$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleKt$combineTuple$9$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleKt$combineTuple$9$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleKt$combineTuple$9$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleKt$combineTuple$9$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleKt$combineTuple$9$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleKt$combineTuple$9$7(mediatorLiveData));
        mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleKt$combineTuple$9$8(mediatorLiveData));
        mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleKt$combineTuple$9$9(mediatorLiveData));
        mediatorLiveData.addSource(liveData10, new LiveDataCombineTupleKt$combineTuple$9$10(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> LiveData<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11) {
        LiveData<T1> liveData12 = liveData;
        LiveData<T2> liveData13 = liveData2;
        LiveData<T3> liveData14 = liveData3;
        LiveData<T4> liveData15 = liveData4;
        LiveData<T5> liveData16 = liveData5;
        LiveData<T6> liveData17 = liveData6;
        LiveData<T7> liveData18 = liveData7;
        LiveData<T8> liveData19 = liveData8;
        LiveData<T9> liveData20 = liveData9;
        LiveData<T10> liveData21 = liveData10;
        Intrinsics.checkNotNullParameter(liveData12, "f1");
        Intrinsics.checkNotNullParameter(liveData13, "f2");
        Intrinsics.checkNotNullParameter(liveData14, "f3");
        Intrinsics.checkNotNullParameter(liveData15, "f4");
        Intrinsics.checkNotNullParameter(liveData16, "f5");
        Intrinsics.checkNotNullParameter(liveData17, "f6");
        Intrinsics.checkNotNullParameter(liveData18, "f7");
        Intrinsics.checkNotNullParameter(liveData19, "f8");
        Intrinsics.checkNotNullParameter(liveData20, "f9");
        Intrinsics.checkNotNullParameter(liveData21, "f10");
        Intrinsics.checkNotNullParameter(liveData11, "f11");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Tuple11 tuple11 = r12;
        Tuple11 tuple112 = new Tuple11(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue(), liveData8.getValue(), liveData9.getValue(), liveData10.getValue(), liveData11.getValue());
        mediatorLiveData.setValue(tuple11);
        mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleKt$combineTuple$10$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleKt$combineTuple$10$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleKt$combineTuple$10$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleKt$combineTuple$10$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleKt$combineTuple$10$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleKt$combineTuple$10$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleKt$combineTuple$10$7(mediatorLiveData));
        mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleKt$combineTuple$10$8(mediatorLiveData));
        mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleKt$combineTuple$10$9(mediatorLiveData));
        mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleKt$combineTuple$10$10(mediatorLiveData));
        mediatorLiveData.addSource(liveData11, new LiveDataCombineTupleKt$combineTuple$10$11(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> LiveData<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12) {
        LiveData<T1> liveData13 = liveData;
        LiveData<T2> liveData14 = liveData2;
        LiveData<T3> liveData15 = liveData3;
        LiveData<T4> liveData16 = liveData4;
        LiveData<T5> liveData17 = liveData5;
        LiveData<T6> liveData18 = liveData6;
        LiveData<T7> liveData19 = liveData7;
        LiveData<T8> liveData20 = liveData8;
        LiveData<T9> liveData21 = liveData9;
        LiveData<T10> liveData22 = liveData10;
        LiveData<T11> liveData23 = liveData11;
        Intrinsics.checkNotNullParameter(liveData13, "f1");
        Intrinsics.checkNotNullParameter(liveData14, "f2");
        Intrinsics.checkNotNullParameter(liveData15, "f3");
        Intrinsics.checkNotNullParameter(liveData16, "f4");
        Intrinsics.checkNotNullParameter(liveData17, "f5");
        Intrinsics.checkNotNullParameter(liveData18, "f6");
        Intrinsics.checkNotNullParameter(liveData19, "f7");
        Intrinsics.checkNotNullParameter(liveData20, "f8");
        Intrinsics.checkNotNullParameter(liveData21, "f9");
        Intrinsics.checkNotNullParameter(liveData22, "f10");
        Intrinsics.checkNotNullParameter(liveData23, "f11");
        Intrinsics.checkNotNullParameter(liveData12, "f12");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Tuple12 tuple12 = r13;
        Tuple12 tuple122 = new Tuple12(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue(), liveData8.getValue(), liveData9.getValue(), liveData10.getValue(), liveData11.getValue(), liveData12.getValue());
        mediatorLiveData.setValue(tuple12);
        mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleKt$combineTuple$11$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleKt$combineTuple$11$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleKt$combineTuple$11$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleKt$combineTuple$11$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleKt$combineTuple$11$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleKt$combineTuple$11$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleKt$combineTuple$11$7(mediatorLiveData));
        mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleKt$combineTuple$11$8(mediatorLiveData));
        mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleKt$combineTuple$11$9(mediatorLiveData));
        mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleKt$combineTuple$11$10(mediatorLiveData));
        mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleKt$combineTuple$11$11(mediatorLiveData));
        mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleKt$combineTuple$11$12(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> LiveData<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12, LiveData<T13> liveData13) {
        LiveData<T1> liveData14 = liveData;
        LiveData<T2> liveData15 = liveData2;
        LiveData<T3> liveData16 = liveData3;
        LiveData<T4> liveData17 = liveData4;
        LiveData<T5> liveData18 = liveData5;
        LiveData<T6> liveData19 = liveData6;
        LiveData<T7> liveData20 = liveData7;
        LiveData<T8> liveData21 = liveData8;
        LiveData<T9> liveData22 = liveData9;
        LiveData<T10> liveData23 = liveData10;
        LiveData<T11> liveData24 = liveData11;
        LiveData<T12> liveData25 = liveData12;
        Intrinsics.checkNotNullParameter(liveData14, "f1");
        Intrinsics.checkNotNullParameter(liveData15, "f2");
        Intrinsics.checkNotNullParameter(liveData16, "f3");
        Intrinsics.checkNotNullParameter(liveData17, "f4");
        Intrinsics.checkNotNullParameter(liveData18, "f5");
        Intrinsics.checkNotNullParameter(liveData19, "f6");
        Intrinsics.checkNotNullParameter(liveData20, "f7");
        Intrinsics.checkNotNullParameter(liveData21, "f8");
        Intrinsics.checkNotNullParameter(liveData22, "f9");
        Intrinsics.checkNotNullParameter(liveData23, "f10");
        Intrinsics.checkNotNullParameter(liveData24, "f11");
        Intrinsics.checkNotNullParameter(liveData25, "f12");
        Intrinsics.checkNotNullParameter(liveData13, "f13");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Tuple13 tuple13 = r14;
        Tuple13 tuple132 = new Tuple13(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue(), liveData8.getValue(), liveData9.getValue(), liveData10.getValue(), liveData11.getValue(), liveData12.getValue(), liveData13.getValue());
        mediatorLiveData.setValue(tuple13);
        mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleKt$combineTuple$12$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleKt$combineTuple$12$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleKt$combineTuple$12$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleKt$combineTuple$12$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleKt$combineTuple$12$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleKt$combineTuple$12$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleKt$combineTuple$12$7(mediatorLiveData));
        mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleKt$combineTuple$12$8(mediatorLiveData));
        mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleKt$combineTuple$12$9(mediatorLiveData));
        mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleKt$combineTuple$12$10(mediatorLiveData));
        mediatorLiveData.addSource(liveData24, new LiveDataCombineTupleKt$combineTuple$12$11(mediatorLiveData));
        mediatorLiveData.addSource(liveData25, new LiveDataCombineTupleKt$combineTuple$12$12(mediatorLiveData));
        mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleKt$combineTuple$12$13(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> LiveData<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12, LiveData<T13> liveData13, LiveData<T14> liveData14) {
        LiveData<T1> liveData15 = liveData;
        LiveData<T2> liveData16 = liveData2;
        LiveData<T3> liveData17 = liveData3;
        LiveData<T4> liveData18 = liveData4;
        LiveData<T5> liveData19 = liveData5;
        LiveData<T6> liveData20 = liveData6;
        LiveData<T7> liveData21 = liveData7;
        LiveData<T8> liveData22 = liveData8;
        LiveData<T9> liveData23 = liveData9;
        LiveData<T10> liveData24 = liveData10;
        LiveData<T11> liveData25 = liveData11;
        LiveData<T12> liveData26 = liveData12;
        LiveData<T13> liveData27 = liveData13;
        LiveData<T14> liveData28 = liveData14;
        Intrinsics.checkNotNullParameter(liveData15, "f1");
        Intrinsics.checkNotNullParameter(liveData16, "f2");
        Intrinsics.checkNotNullParameter(liveData17, "f3");
        Intrinsics.checkNotNullParameter(liveData18, "f4");
        Intrinsics.checkNotNullParameter(liveData19, "f5");
        Intrinsics.checkNotNullParameter(liveData20, "f6");
        Intrinsics.checkNotNullParameter(liveData21, "f7");
        Intrinsics.checkNotNullParameter(liveData22, "f8");
        Intrinsics.checkNotNullParameter(liveData23, "f9");
        Intrinsics.checkNotNullParameter(liveData24, "f10");
        Intrinsics.checkNotNullParameter(liveData25, "f11");
        Intrinsics.checkNotNullParameter(liveData26, "f12");
        Intrinsics.checkNotNullParameter(liveData27, "f13");
        Intrinsics.checkNotNullParameter(liveData28, "f14");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Tuple14 tuple14 = r15;
        Tuple14 tuple142 = new Tuple14(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue(), liveData8.getValue(), liveData9.getValue(), liveData10.getValue(), liveData11.getValue(), liveData12.getValue(), liveData13.getValue(), liveData14.getValue());
        mediatorLiveData.setValue(tuple142);
        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleKt$combineTuple$13$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleKt$combineTuple$13$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleKt$combineTuple$13$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleKt$combineTuple$13$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleKt$combineTuple$13$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleKt$combineTuple$13$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleKt$combineTuple$13$7(mediatorLiveData));
        mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleKt$combineTuple$13$8(mediatorLiveData));
        mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleKt$combineTuple$13$9(mediatorLiveData));
        mediatorLiveData.addSource(liveData24, new LiveDataCombineTupleKt$combineTuple$13$10(mediatorLiveData));
        mediatorLiveData.addSource(liveData25, new LiveDataCombineTupleKt$combineTuple$13$11(mediatorLiveData));
        mediatorLiveData.addSource(liveData26, new LiveDataCombineTupleKt$combineTuple$13$12(mediatorLiveData));
        mediatorLiveData.addSource(liveData27, new LiveDataCombineTupleKt$combineTuple$13$13(mediatorLiveData));
        mediatorLiveData.addSource(liveData28, new LiveDataCombineTupleKt$combineTuple$13$14(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> LiveData<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12, LiveData<T13> liveData13, LiveData<T14> liveData14, LiveData<T15> liveData15) {
        LiveData<T1> liveData16 = liveData;
        LiveData<T2> liveData17 = liveData2;
        LiveData<T3> liveData18 = liveData3;
        LiveData<T4> liveData19 = liveData4;
        LiveData<T5> liveData20 = liveData5;
        LiveData<T6> liveData21 = liveData6;
        LiveData<T7> liveData22 = liveData7;
        LiveData<T8> liveData23 = liveData8;
        LiveData<T9> liveData24 = liveData9;
        LiveData<T10> liveData25 = liveData10;
        LiveData<T11> liveData26 = liveData11;
        LiveData<T12> liveData27 = liveData12;
        LiveData<T13> liveData28 = liveData13;
        LiveData<T14> liveData29 = liveData14;
        Intrinsics.checkNotNullParameter(liveData16, "f1");
        Intrinsics.checkNotNullParameter(liveData17, "f2");
        Intrinsics.checkNotNullParameter(liveData18, "f3");
        Intrinsics.checkNotNullParameter(liveData19, "f4");
        Intrinsics.checkNotNullParameter(liveData20, "f5");
        Intrinsics.checkNotNullParameter(liveData21, "f6");
        Intrinsics.checkNotNullParameter(liveData22, "f7");
        Intrinsics.checkNotNullParameter(liveData23, "f8");
        Intrinsics.checkNotNullParameter(liveData24, "f9");
        Intrinsics.checkNotNullParameter(liveData25, "f10");
        Intrinsics.checkNotNullParameter(liveData26, "f11");
        Intrinsics.checkNotNullParameter(liveData27, "f12");
        Intrinsics.checkNotNullParameter(liveData28, "f13");
        Intrinsics.checkNotNullParameter(liveData29, "f14");
        Intrinsics.checkNotNullParameter(liveData15, "f15");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.setValue(new Tuple15(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue(), liveData8.getValue(), liveData9.getValue(), liveData10.getValue(), liveData11.getValue(), liveData12.getValue(), liveData13.getValue(), liveData14.getValue(), liveData15.getValue()));
        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleKt$combineTuple$14$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleKt$combineTuple$14$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleKt$combineTuple$14$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleKt$combineTuple$14$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleKt$combineTuple$14$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleKt$combineTuple$14$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleKt$combineTuple$14$7(mediatorLiveData));
        mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleKt$combineTuple$14$8(mediatorLiveData));
        mediatorLiveData.addSource(liveData24, new LiveDataCombineTupleKt$combineTuple$14$9(mediatorLiveData));
        mediatorLiveData.addSource(liveData25, new LiveDataCombineTupleKt$combineTuple$14$10(mediatorLiveData));
        mediatorLiveData.addSource(liveData26, new LiveDataCombineTupleKt$combineTuple$14$11(mediatorLiveData));
        mediatorLiveData.addSource(liveData27, new LiveDataCombineTupleKt$combineTuple$14$12(mediatorLiveData));
        mediatorLiveData.addSource(liveData28, new LiveDataCombineTupleKt$combineTuple$14$13(mediatorLiveData));
        mediatorLiveData.addSource(liveData29, new LiveDataCombineTupleKt$combineTuple$14$14(mediatorLiveData));
        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleKt$combineTuple$14$15(mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> LiveData<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> combineTuple(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12, LiveData<T13> liveData13, LiveData<T14> liveData14, LiveData<T15> liveData15, LiveData<T16> liveData16) {
        LiveData<T1> liveData17 = liveData;
        LiveData<T2> liveData18 = liveData2;
        LiveData<T3> liveData19 = liveData3;
        LiveData<T4> liveData20 = liveData4;
        LiveData<T5> liveData21 = liveData5;
        LiveData<T6> liveData22 = liveData6;
        LiveData<T7> liveData23 = liveData7;
        LiveData<T8> liveData24 = liveData8;
        LiveData<T9> liveData25 = liveData9;
        LiveData<T10> liveData26 = liveData10;
        LiveData<T11> liveData27 = liveData11;
        LiveData<T12> liveData28 = liveData12;
        LiveData<T13> liveData29 = liveData13;
        LiveData<T14> liveData30 = liveData14;
        Intrinsics.checkNotNullParameter(liveData17, "f1");
        Intrinsics.checkNotNullParameter(liveData18, "f2");
        Intrinsics.checkNotNullParameter(liveData19, "f3");
        Intrinsics.checkNotNullParameter(liveData20, "f4");
        Intrinsics.checkNotNullParameter(liveData21, "f5");
        Intrinsics.checkNotNullParameter(liveData22, "f6");
        Intrinsics.checkNotNullParameter(liveData23, "f7");
        Intrinsics.checkNotNullParameter(liveData24, "f8");
        Intrinsics.checkNotNullParameter(liveData25, "f9");
        Intrinsics.checkNotNullParameter(liveData26, "f10");
        Intrinsics.checkNotNullParameter(liveData27, "f11");
        Intrinsics.checkNotNullParameter(liveData28, "f12");
        Intrinsics.checkNotNullParameter(liveData29, "f13");
        Intrinsics.checkNotNullParameter(liveData30, "f14");
        Intrinsics.checkNotNullParameter(liveData15, "f15");
        Intrinsics.checkNotNullParameter(liveData16, "f16");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.setValue(new Tuple16(liveData.getValue(), liveData2.getValue(), liveData3.getValue(), liveData4.getValue(), liveData5.getValue(), liveData6.getValue(), liveData7.getValue(), liveData8.getValue(), liveData9.getValue(), liveData10.getValue(), liveData11.getValue(), liveData12.getValue(), liveData13.getValue(), liveData14.getValue(), liveData15.getValue(), liveData16.getValue()));
        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleKt$combineTuple$15$1(mediatorLiveData));
        mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleKt$combineTuple$15$2(mediatorLiveData));
        mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleKt$combineTuple$15$3(mediatorLiveData));
        mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleKt$combineTuple$15$4(mediatorLiveData));
        mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleKt$combineTuple$15$5(mediatorLiveData));
        mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleKt$combineTuple$15$6(mediatorLiveData));
        mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleKt$combineTuple$15$7(mediatorLiveData));
        mediatorLiveData.addSource(liveData24, new LiveDataCombineTupleKt$combineTuple$15$8(mediatorLiveData));
        mediatorLiveData.addSource(liveData25, new LiveDataCombineTupleKt$combineTuple$15$9(mediatorLiveData));
        mediatorLiveData.addSource(liveData26, new LiveDataCombineTupleKt$combineTuple$15$10(mediatorLiveData));
        mediatorLiveData.addSource(liveData27, new LiveDataCombineTupleKt$combineTuple$15$11(mediatorLiveData));
        mediatorLiveData.addSource(liveData28, new LiveDataCombineTupleKt$combineTuple$15$12(mediatorLiveData));
        mediatorLiveData.addSource(liveData29, new LiveDataCombineTupleKt$combineTuple$15$13(mediatorLiveData));
        mediatorLiveData.addSource(liveData30, new LiveDataCombineTupleKt$combineTuple$15$14(mediatorLiveData));
        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleKt$combineTuple$15$15(mediatorLiveData));
        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleKt$combineTuple$15$16(mediatorLiveData));
        return mediatorLiveData;
    }
}
