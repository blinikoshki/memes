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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\u001af\u0010\u0000\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t0\b0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\u001a\u0001\u0010\u0000\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f0\u000b0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\u001a¢\u0001\u0010\u0000\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f0\u000e0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0001\u001aÀ\u0001\u0010\u0000\u001a,\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00120\u00110\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\u001aÞ\u0001\u0010\u0000\u001a2\u0012.\u0012,\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00150\u00140\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0001\u001aü\u0001\u0010\u0000\u001a8\u00124\u00122\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00180\u00170\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u0005\"\b\b\u0007\u0010\u0018*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0001\u001a\u0002\u0010\u0000\u001a>\u0012:\u00128\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b0\u001a0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u0005\"\b\b\u0007\u0010\u0018*\u00020\u0005\"\b\b\b\u0010\u001b*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0001\u001a¸\u0002\u0010\u0000\u001aD\u0012@\u0012>\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e0\u001d0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u0005\"\b\b\u0007\u0010\u0018*\u00020\u0005\"\b\b\b\u0010\u001b*\u00020\u0005\"\b\b\t\u0010\u001e*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0001\u001aÖ\u0002\u0010\u0000\u001aJ\u0012F\u0012D\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!0 0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u0005\"\b\b\u0007\u0010\u0018*\u00020\u0005\"\b\b\b\u0010\u001b*\u00020\u0005\"\b\b\t\u0010\u001e*\u00020\u0005\"\b\b\n\u0010!*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u0001\u001aô\u0002\u0010\u0000\u001aP\u0012L\u0012J\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$0#0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u0005\"\b\b\u0007\u0010\u0018*\u00020\u0005\"\b\b\b\u0010\u001b*\u00020\u0005\"\b\b\t\u0010\u001e*\u00020\u0005\"\b\b\n\u0010!*\u00020\u0005\"\b\b\u000b\u0010$*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u00012\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0\u0001\u001a\u0003\u0010\u0000\u001aV\u0012R\u0012P\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'0&0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u0005\"\b\b\u0007\u0010\u0018*\u00020\u0005\"\b\b\b\u0010\u001b*\u00020\u0005\"\b\b\t\u0010\u001e*\u00020\u0005\"\b\b\n\u0010!*\u00020\u0005\"\b\b\u000b\u0010$*\u00020\u0005\"\b\b\f\u0010'*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u00012\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0\u0001\u001a°\u0003\u0010\u0000\u001a\\\u0012X\u0012V\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*0)0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u0005\"\b\b\u0007\u0010\u0018*\u00020\u0005\"\b\b\b\u0010\u001b*\u00020\u0005\"\b\b\t\u0010\u001e*\u00020\u0005\"\b\b\n\u0010!*\u00020\u0005\"\b\b\u000b\u0010$*\u00020\u0005\"\b\b\f\u0010'*\u00020\u0005\"\b\b\r\u0010**\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u00012\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0\u0001\u001aÎ\u0003\u0010\u0000\u001ab\u0012^\u0012\\\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-0,0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u0005\"\b\b\u0007\u0010\u0018*\u00020\u0005\"\b\b\b\u0010\u001b*\u00020\u0005\"\b\b\t\u0010\u001e*\u00020\u0005\"\b\b\n\u0010!*\u00020\u0005\"\b\b\u000b\u0010$*\u00020\u0005\"\b\b\f\u0010'*\u00020\u0005\"\b\b\r\u0010**\u00020\u0005\"\b\b\u000e\u0010-*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u00012\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0\u0001\u001aì\u0003\u0010\u0000\u001ah\u0012d\u0012b\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H00/0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\t*\u00020\u0005\"\b\b\u0003\u0010\f*\u00020\u0005\"\b\b\u0004\u0010\u000f*\u00020\u0005\"\b\b\u0005\u0010\u0012*\u00020\u0005\"\b\b\u0006\u0010\u0015*\u00020\u0005\"\b\b\u0007\u0010\u0018*\u00020\u0005\"\b\b\b\u0010\u001b*\u00020\u0005\"\b\b\t\u0010\u001e*\u00020\u0005\"\b\b\n\u0010!*\u00020\u0005\"\b\b\u000b\u0010$*\u00020\u0005\"\b\b\f\u0010'*\u00020\u0005\"\b\b\r\u0010**\u00020\u0005\"\b\b\u000e\u0010-*\u00020\u0005\"\b\b\u000f\u00100*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0\u00012\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H$0\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u0001¨\u00062"}, mo26107d2 = {"combineTupleNonNull", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "T1", "T2", "", "f1", "f2", "Lkotlin/Triple;", "T3", "f3", "Lcom/zhuinden/tupleskt/Tuple4;", "T4", "f4", "Lcom/zhuinden/tupleskt/Tuple5;", "T5", "f5", "Lcom/zhuinden/tupleskt/Tuple6;", "T6", "f6", "Lcom/zhuinden/tupleskt/Tuple7;", "T7", "f7", "Lcom/zhuinden/tupleskt/Tuple8;", "T8", "f8", "Lcom/zhuinden/tupleskt/Tuple9;", "T9", "f9", "Lcom/zhuinden/tupleskt/Tuple10;", "T10", "f10", "Lcom/zhuinden/tupleskt/Tuple11;", "T11", "f11", "Lcom/zhuinden/tupleskt/Tuple12;", "T12", "f12", "Lcom/zhuinden/tupleskt/Tuple13;", "T13", "f13", "Lcom/zhuinden/tupleskt/Tuple14;", "T14", "f14", "Lcom/zhuinden/tupleskt/Tuple15;", "T15", "f15", "Lcom/zhuinden/tupleskt/Tuple16;", "T16", "f16", "livedata-combinetuple-kt_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: LiveDataCombineTupleNonNull.kt */
public final class LiveDataCombineTupleNonNullKt {
    public static final <T1, T2> LiveData<Pair<T1, T2>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                mediatorLiveData.setValue(new Pair(value, value2));
                mediatorLiveData.addSource(liveData, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$1$3(mediatorLiveData));
                mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$1$4(mediatorLiveData));
                return mediatorLiveData;
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3> LiveData<Triple<T1, T2, T3>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        Intrinsics.checkNotNullParameter(liveData3, "f3");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    mediatorLiveData.setValue(new Triple(value, value2, value3));
                    mediatorLiveData.addSource(liveData, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$2$4(mediatorLiveData));
                    mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$2$5(mediatorLiveData));
                    mediatorLiveData.addSource(liveData3, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$2$6(mediatorLiveData));
                    return mediatorLiveData;
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4> LiveData<Tuple4<T1, T2, T3, T4>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        Intrinsics.checkNotNullParameter(liveData3, "f3");
        Intrinsics.checkNotNullParameter(liveData4, "f4");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        mediatorLiveData.setValue(new Tuple4(value, value2, value3, value4));
                        mediatorLiveData.addSource(liveData, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$3$5(mediatorLiveData));
                        mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$3$6(mediatorLiveData));
                        mediatorLiveData.addSource(liveData3, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$3$7(mediatorLiveData));
                        mediatorLiveData.addSource(liveData4, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$3$8(mediatorLiveData));
                        return mediatorLiveData;
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5> LiveData<Tuple5<T1, T2, T3, T4, T5>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        Intrinsics.checkNotNullParameter(liveData3, "f3");
        Intrinsics.checkNotNullParameter(liveData4, "f4");
        Intrinsics.checkNotNullParameter(liveData5, "f5");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            mediatorLiveData.setValue(new Tuple5(value, value2, value3, value4, value5));
                            mediatorLiveData.addSource(liveData, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$4$6(mediatorLiveData));
                            mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$4$7(mediatorLiveData));
                            mediatorLiveData.addSource(liveData3, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$4$8(mediatorLiveData));
                            mediatorLiveData.addSource(liveData4, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$4$9(mediatorLiveData));
                            mediatorLiveData.addSource(liveData5, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$4$10(mediatorLiveData));
                            return mediatorLiveData;
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6> LiveData<Tuple6<T1, T2, T3, T4, T5, T6>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6) {
        Intrinsics.checkNotNullParameter(liveData, "f1");
        Intrinsics.checkNotNullParameter(liveData2, "f2");
        Intrinsics.checkNotNullParameter(liveData3, "f3");
        Intrinsics.checkNotNullParameter(liveData4, "f4");
        Intrinsics.checkNotNullParameter(liveData5, "f5");
        Intrinsics.checkNotNullParameter(liveData6, "f6");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                mediatorLiveData.setValue(new Tuple6(value, value2, value3, value4, value5, value6));
                                mediatorLiveData.addSource(liveData, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$5$7(mediatorLiveData));
                                mediatorLiveData.addSource(liveData2, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$5$8(mediatorLiveData));
                                mediatorLiveData.addSource(liveData3, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$5$9(mediatorLiveData));
                                mediatorLiveData.addSource(liveData4, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$5$10(mediatorLiveData));
                                mediatorLiveData.addSource(liveData5, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$5$11(mediatorLiveData));
                                mediatorLiveData.addSource(liveData6, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$5$12(mediatorLiveData));
                                return mediatorLiveData;
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7> LiveData<Tuple7<T1, T2, T3, T4, T5, T6, T7>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7) {
        LiveData<T1> liveData8 = liveData;
        LiveData<T2> liveData9 = liveData2;
        LiveData<T3> liveData10 = liveData3;
        LiveData<T4> liveData11 = liveData4;
        LiveData<T5> liveData12 = liveData5;
        LiveData<T6> liveData13 = liveData6;
        LiveData<T7> liveData14 = liveData7;
        Intrinsics.checkNotNullParameter(liveData8, "f1");
        Intrinsics.checkNotNullParameter(liveData9, "f2");
        Intrinsics.checkNotNullParameter(liveData10, "f3");
        Intrinsics.checkNotNullParameter(liveData11, "f4");
        Intrinsics.checkNotNullParameter(liveData12, "f5");
        Intrinsics.checkNotNullParameter(liveData13, "f6");
        Intrinsics.checkNotNullParameter(liveData14, "f7");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    Tuple7 tuple7 = r8;
                                    Tuple7 tuple72 = new Tuple7(value, value2, value3, value4, value5, value6, value7);
                                    mediatorLiveData.setValue(tuple72);
                                    mediatorLiveData.addSource(liveData8, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$6$8(mediatorLiveData));
                                    mediatorLiveData.addSource(liveData9, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$6$9(mediatorLiveData));
                                    mediatorLiveData.addSource(liveData10, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$6$10(mediatorLiveData));
                                    mediatorLiveData.addSource(liveData11, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$6$11(mediatorLiveData));
                                    mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$6$12(mediatorLiveData));
                                    mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$6$13(mediatorLiveData));
                                    mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$6$14(mediatorLiveData));
                                    return mediatorLiveData;
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8> LiveData<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8) {
        LiveData<T1> liveData9 = liveData;
        LiveData<T2> liveData10 = liveData2;
        LiveData<T3> liveData11 = liveData3;
        LiveData<T4> liveData12 = liveData4;
        LiveData<T5> liveData13 = liveData5;
        LiveData<T6> liveData14 = liveData6;
        LiveData<T7> liveData15 = liveData7;
        LiveData<T8> liveData16 = liveData8;
        Intrinsics.checkNotNullParameter(liveData9, "f1");
        Intrinsics.checkNotNullParameter(liveData10, "f2");
        Intrinsics.checkNotNullParameter(liveData11, "f3");
        Intrinsics.checkNotNullParameter(liveData12, "f4");
        Intrinsics.checkNotNullParameter(liveData13, "f5");
        Intrinsics.checkNotNullParameter(liveData14, "f6");
        Intrinsics.checkNotNullParameter(liveData15, "f7");
        Intrinsics.checkNotNullParameter(liveData16, "f8");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    T8 value8 = liveData8.getValue();
                                    if (value8 != null) {
                                        Tuple8 tuple8 = r9;
                                        Tuple8 tuple82 = new Tuple8(value, value2, value3, value4, value5, value6, value7, value8);
                                        mediatorLiveData.setValue(tuple82);
                                        mediatorLiveData.addSource(liveData9, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$7$9(mediatorLiveData));
                                        mediatorLiveData.addSource(liveData10, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$7$10(mediatorLiveData));
                                        mediatorLiveData.addSource(liveData11, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$7$11(mediatorLiveData));
                                        mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$7$12(mediatorLiveData));
                                        mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$7$13(mediatorLiveData));
                                        mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$7$14(mediatorLiveData));
                                        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$7$15(mediatorLiveData));
                                        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$7$16(mediatorLiveData));
                                        return mediatorLiveData;
                                    }
                                    throw new IllegalStateException("Value of f8 was null".toString());
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9> LiveData<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9) {
        LiveData<T1> liveData10 = liveData;
        LiveData<T2> liveData11 = liveData2;
        LiveData<T3> liveData12 = liveData3;
        LiveData<T4> liveData13 = liveData4;
        LiveData<T5> liveData14 = liveData5;
        LiveData<T6> liveData15 = liveData6;
        LiveData<T7> liveData16 = liveData7;
        LiveData<T8> liveData17 = liveData8;
        LiveData<T9> liveData18 = liveData9;
        Intrinsics.checkNotNullParameter(liveData10, "f1");
        Intrinsics.checkNotNullParameter(liveData11, "f2");
        Intrinsics.checkNotNullParameter(liveData12, "f3");
        Intrinsics.checkNotNullParameter(liveData13, "f4");
        Intrinsics.checkNotNullParameter(liveData14, "f5");
        Intrinsics.checkNotNullParameter(liveData15, "f6");
        Intrinsics.checkNotNullParameter(liveData16, "f7");
        Intrinsics.checkNotNullParameter(liveData17, "f8");
        Intrinsics.checkNotNullParameter(liveData18, "f9");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    T8 value8 = liveData8.getValue();
                                    if (value8 != null) {
                                        T9 value9 = liveData9.getValue();
                                        if (value9 != null) {
                                            Tuple9 tuple9 = r10;
                                            Tuple9 tuple92 = new Tuple9(value, value2, value3, value4, value5, value6, value7, value8, value9);
                                            mediatorLiveData.setValue(tuple92);
                                            mediatorLiveData.addSource(liveData10, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$8$10(mediatorLiveData));
                                            mediatorLiveData.addSource(liveData11, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$8$11(mediatorLiveData));
                                            mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$8$12(mediatorLiveData));
                                            mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$8$13(mediatorLiveData));
                                            mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$8$14(mediatorLiveData));
                                            mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$8$15(mediatorLiveData));
                                            mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$8$16(mediatorLiveData));
                                            mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$8$17(mediatorLiveData));
                                            mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$8$18(mediatorLiveData));
                                            return mediatorLiveData;
                                        }
                                        throw new IllegalStateException("Value of f9 was null".toString());
                                    }
                                    throw new IllegalStateException("Value of f8 was null".toString());
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> LiveData<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10) {
        LiveData<T1> liveData11 = liveData;
        LiveData<T2> liveData12 = liveData2;
        LiveData<T3> liveData13 = liveData3;
        LiveData<T4> liveData14 = liveData4;
        LiveData<T5> liveData15 = liveData5;
        LiveData<T6> liveData16 = liveData6;
        LiveData<T7> liveData17 = liveData7;
        LiveData<T8> liveData18 = liveData8;
        LiveData<T9> liveData19 = liveData9;
        LiveData<T10> liveData20 = liveData10;
        Intrinsics.checkNotNullParameter(liveData11, "f1");
        Intrinsics.checkNotNullParameter(liveData12, "f2");
        Intrinsics.checkNotNullParameter(liveData13, "f3");
        Intrinsics.checkNotNullParameter(liveData14, "f4");
        Intrinsics.checkNotNullParameter(liveData15, "f5");
        Intrinsics.checkNotNullParameter(liveData16, "f6");
        Intrinsics.checkNotNullParameter(liveData17, "f7");
        Intrinsics.checkNotNullParameter(liveData18, "f8");
        Intrinsics.checkNotNullParameter(liveData19, "f9");
        Intrinsics.checkNotNullParameter(liveData20, "f10");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    T8 value8 = liveData8.getValue();
                                    if (value8 != null) {
                                        T9 value9 = liveData9.getValue();
                                        if (value9 != null) {
                                            T10 value10 = liveData10.getValue();
                                            if (value10 != null) {
                                                Tuple10 tuple10 = r11;
                                                Tuple10 tuple102 = new Tuple10(value, value2, value3, value4, value5, value6, value7, value8, value9, value10);
                                                mediatorLiveData.setValue(tuple102);
                                                mediatorLiveData.addSource(liveData11, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$11(mediatorLiveData));
                                                mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$12(mediatorLiveData));
                                                mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$13(mediatorLiveData));
                                                mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$14(mediatorLiveData));
                                                mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$15(mediatorLiveData));
                                                mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$16(mediatorLiveData));
                                                mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$17(mediatorLiveData));
                                                mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$18(mediatorLiveData));
                                                mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$19(mediatorLiveData));
                                                mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$9$20(mediatorLiveData));
                                                return mediatorLiveData;
                                            }
                                            throw new IllegalStateException("Value of f10 was null".toString());
                                        }
                                        throw new IllegalStateException("Value of f9 was null".toString());
                                    }
                                    throw new IllegalStateException("Value of f8 was null".toString());
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> LiveData<Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11) {
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
        LiveData<T11> liveData22 = liveData11;
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
        Intrinsics.checkNotNullParameter(liveData22, "f11");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    T8 value8 = liveData8.getValue();
                                    if (value8 != null) {
                                        T9 value9 = liveData9.getValue();
                                        if (value9 != null) {
                                            T10 value10 = liveData10.getValue();
                                            if (value10 != null) {
                                                T11 value11 = liveData11.getValue();
                                                if (value11 != null) {
                                                    Tuple11 tuple11 = r12;
                                                    Tuple11 tuple112 = new Tuple11(value, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11);
                                                    mediatorLiveData.setValue(tuple112);
                                                    mediatorLiveData.addSource(liveData12, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$12(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$13(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$14(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$15(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$16(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$17(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$18(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$19(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$20(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$21(mediatorLiveData));
                                                    mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$10$22(mediatorLiveData));
                                                    return mediatorLiveData;
                                                }
                                                throw new IllegalStateException("Value of f11 was null".toString());
                                            }
                                            throw new IllegalStateException("Value of f10 was null".toString());
                                        }
                                        throw new IllegalStateException("Value of f9 was null".toString());
                                    }
                                    throw new IllegalStateException("Value of f8 was null".toString());
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> LiveData<Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12) {
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
        LiveData<T12> liveData24 = liveData12;
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
        Intrinsics.checkNotNullParameter(liveData24, "f12");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    T8 value8 = liveData8.getValue();
                                    if (value8 != null) {
                                        T9 value9 = liveData9.getValue();
                                        if (value9 != null) {
                                            T10 value10 = liveData10.getValue();
                                            if (value10 != null) {
                                                T11 value11 = liveData11.getValue();
                                                if (value11 != null) {
                                                    T12 value12 = liveData12.getValue();
                                                    if (value12 != null) {
                                                        Tuple12 tuple12 = r13;
                                                        Tuple12 tuple122 = new Tuple12(value, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12);
                                                        mediatorLiveData.setValue(tuple122);
                                                        mediatorLiveData.addSource(liveData13, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$13(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$14(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$15(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$16(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$17(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$18(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$19(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$20(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$21(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$22(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$23(mediatorLiveData));
                                                        mediatorLiveData.addSource(liveData24, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$11$24(mediatorLiveData));
                                                        Unit unit = Unit.INSTANCE;
                                                        return mediatorLiveData;
                                                    }
                                                    throw new IllegalStateException("Value of f12 was null".toString());
                                                }
                                                throw new IllegalStateException("Value of f11 was null".toString());
                                            }
                                            throw new IllegalStateException("Value of f10 was null".toString());
                                        }
                                        throw new IllegalStateException("Value of f9 was null".toString());
                                    }
                                    throw new IllegalStateException("Value of f8 was null".toString());
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> LiveData<Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12, LiveData<T13> liveData13) {
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
        LiveData<T13> liveData26 = liveData13;
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
        Intrinsics.checkNotNullParameter(liveData26, "f13");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    T8 value8 = liveData8.getValue();
                                    if (value8 != null) {
                                        T9 value9 = liveData9.getValue();
                                        if (value9 != null) {
                                            T10 value10 = liveData10.getValue();
                                            if (value10 != null) {
                                                T11 value11 = liveData11.getValue();
                                                if (value11 != null) {
                                                    T12 value12 = liveData12.getValue();
                                                    if (value12 != null) {
                                                        T13 value13 = liveData13.getValue();
                                                        if (value13 != null) {
                                                            Tuple13 tuple13 = r14;
                                                            Tuple13 tuple132 = new Tuple13(value, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13);
                                                            mediatorLiveData.setValue(tuple132);
                                                            mediatorLiveData.addSource(liveData14, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$14(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$15(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$16(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$17(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$18(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$19(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$20(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$21(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$22(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$23(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData24, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$24(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData25, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$25(mediatorLiveData));
                                                            mediatorLiveData.addSource(liveData26, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$12$26(mediatorLiveData));
                                                            Unit unit = Unit.INSTANCE;
                                                            return mediatorLiveData;
                                                        }
                                                        throw new IllegalStateException("Value of f13 was null".toString());
                                                    }
                                                    throw new IllegalStateException("Value of f12 was null".toString());
                                                }
                                                throw new IllegalStateException("Value of f11 was null".toString());
                                            }
                                            throw new IllegalStateException("Value of f10 was null".toString());
                                        }
                                        throw new IllegalStateException("Value of f9 was null".toString());
                                    }
                                    throw new IllegalStateException("Value of f8 was null".toString());
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> LiveData<Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12, LiveData<T13> liveData13, LiveData<T14> liveData14) {
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
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    T8 value8 = liveData8.getValue();
                                    if (value8 != null) {
                                        T9 value9 = liveData9.getValue();
                                        if (value9 != null) {
                                            T10 value10 = liveData10.getValue();
                                            if (value10 != null) {
                                                T11 value11 = liveData11.getValue();
                                                if (value11 != null) {
                                                    T12 value12 = liveData12.getValue();
                                                    if (value12 != null) {
                                                        T13 value13 = liveData13.getValue();
                                                        if (value13 != null) {
                                                            T14 value14 = liveData14.getValue();
                                                            if (value14 != null) {
                                                                Tuple14 tuple14 = r15;
                                                                Tuple14 tuple142 = new Tuple14(value, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14);
                                                                mediatorLiveData.setValue(tuple142);
                                                                mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$15(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$16(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$17(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$18(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$19(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$20(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$21(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$22(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$23(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData24, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$24(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData25, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$25(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData26, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$26(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData27, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$27(mediatorLiveData));
                                                                mediatorLiveData.addSource(liveData28, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$13$28(mediatorLiveData));
                                                                Unit unit = Unit.INSTANCE;
                                                                return mediatorLiveData;
                                                            }
                                                            throw new IllegalStateException("Value of f14 was null".toString());
                                                        }
                                                        throw new IllegalStateException("Value of f13 was null".toString());
                                                    }
                                                    throw new IllegalStateException("Value of f12 was null".toString());
                                                }
                                                throw new IllegalStateException("Value of f11 was null".toString());
                                            }
                                            throw new IllegalStateException("Value of f10 was null".toString());
                                        }
                                        throw new IllegalStateException("Value of f9 was null".toString());
                                    }
                                    throw new IllegalStateException("Value of f8 was null".toString());
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> LiveData<Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12, LiveData<T13> liveData13, LiveData<T14> liveData14, LiveData<T15> liveData15) {
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
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    T8 value8 = liveData8.getValue();
                                    if (value8 != null) {
                                        T9 value9 = liveData9.getValue();
                                        if (value9 != null) {
                                            T10 value10 = liveData10.getValue();
                                            if (value10 != null) {
                                                T11 value11 = liveData11.getValue();
                                                if (value11 != null) {
                                                    T12 value12 = liveData12.getValue();
                                                    if (value12 != null) {
                                                        T13 value13 = liveData13.getValue();
                                                        if (value13 != null) {
                                                            T14 value14 = liveData14.getValue();
                                                            if (value14 != null) {
                                                                T15 value15 = liveData15.getValue();
                                                                if (value15 != null) {
                                                                    mediatorLiveData.setValue(new Tuple15(value, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15));
                                                                    mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$16(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$17(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$18(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$19(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$20(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$21(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$22(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$23(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData24, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$24(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData25, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$25(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData26, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$26(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData27, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$27(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData28, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$28(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData29, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$29(mediatorLiveData));
                                                                    mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$14$30(mediatorLiveData));
                                                                    Unit unit = Unit.INSTANCE;
                                                                    return mediatorLiveData;
                                                                }
                                                                throw new IllegalStateException("Value of f15 was null".toString());
                                                            }
                                                            throw new IllegalStateException("Value of f14 was null".toString());
                                                        }
                                                        throw new IllegalStateException("Value of f13 was null".toString());
                                                    }
                                                    throw new IllegalStateException("Value of f12 was null".toString());
                                                }
                                                throw new IllegalStateException("Value of f11 was null".toString());
                                            }
                                            throw new IllegalStateException("Value of f10 was null".toString());
                                        }
                                        throw new IllegalStateException("Value of f9 was null".toString());
                                    }
                                    throw new IllegalStateException("Value of f8 was null".toString());
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> LiveData<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> combineTupleNonNull(LiveData<T1> liveData, LiveData<T2> liveData2, LiveData<T3> liveData3, LiveData<T4> liveData4, LiveData<T5> liveData5, LiveData<T6> liveData6, LiveData<T7> liveData7, LiveData<T8> liveData8, LiveData<T9> liveData9, LiveData<T10> liveData10, LiveData<T11> liveData11, LiveData<T12> liveData12, LiveData<T13> liveData13, LiveData<T14> liveData14, LiveData<T15> liveData15, LiveData<T16> liveData16) {
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
        T1 value = liveData.getValue();
        if (value != null) {
            T2 value2 = liveData2.getValue();
            if (value2 != null) {
                T3 value3 = liveData3.getValue();
                if (value3 != null) {
                    T4 value4 = liveData4.getValue();
                    if (value4 != null) {
                        T5 value5 = liveData5.getValue();
                        if (value5 != null) {
                            T6 value6 = liveData6.getValue();
                            if (value6 != null) {
                                T7 value7 = liveData7.getValue();
                                if (value7 != null) {
                                    T8 value8 = liveData8.getValue();
                                    if (value8 != null) {
                                        T9 value9 = liveData9.getValue();
                                        if (value9 != null) {
                                            T10 value10 = liveData10.getValue();
                                            if (value10 != null) {
                                                T11 value11 = liveData11.getValue();
                                                if (value11 != null) {
                                                    T12 value12 = liveData12.getValue();
                                                    if (value12 != null) {
                                                        T13 value13 = liveData13.getValue();
                                                        if (value13 != null) {
                                                            T14 value14 = liveData14.getValue();
                                                            if (value14 != null) {
                                                                T15 value15 = liveData15.getValue();
                                                                if (value15 != null) {
                                                                    T16 value16 = liveData16.getValue();
                                                                    if (value16 != null) {
                                                                        mediatorLiveData.setValue(new Tuple16(value, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15, value16));
                                                                        mediatorLiveData.addSource(liveData17, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$17(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData18, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$18(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData19, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$19(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData20, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$20(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData21, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$21(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData22, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$22(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData23, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$23(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData24, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$24(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData25, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$25(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData26, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$26(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData27, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$27(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData28, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$28(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData29, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$29(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData30, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$30(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData15, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$31(mediatorLiveData));
                                                                        mediatorLiveData.addSource(liveData16, new LiveDataCombineTupleNonNullKt$combineTupleNonNull$15$32(mediatorLiveData));
                                                                        Unit unit = Unit.INSTANCE;
                                                                        return mediatorLiveData;
                                                                    }
                                                                    throw new IllegalStateException("Value of f16 was null".toString());
                                                                }
                                                                throw new IllegalStateException("Value of f15 was null".toString());
                                                            }
                                                            throw new IllegalStateException("Value of f14 was null".toString());
                                                        }
                                                        throw new IllegalStateException("Value of f13 was null".toString());
                                                    }
                                                    throw new IllegalStateException("Value of f12 was null".toString());
                                                }
                                                throw new IllegalStateException("Value of f11 was null".toString());
                                            }
                                            throw new IllegalStateException("Value of f10 was null".toString());
                                        }
                                        throw new IllegalStateException("Value of f9 was null".toString());
                                    }
                                    throw new IllegalStateException("Value of f8 was null".toString());
                                }
                                throw new IllegalStateException("Value of f7 was null".toString());
                            }
                            throw new IllegalStateException("Value of f6 was null".toString());
                        }
                        throw new IllegalStateException("Value of f5 was null".toString());
                    }
                    throw new IllegalStateException("Value of f4 was null".toString());
                }
                throw new IllegalStateException("Value of f3 was null".toString());
            }
            throw new IllegalStateException("Value of f2 was null".toString());
        }
        throw new IllegalStateException("Value of f1 was null".toString());
    }
}
