package com.kbz_b.flutter

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.boost_core.R
import com.google.gson.Gson
import com.idlefish.flutterboost.containers.FlutterBoostFragment
import com.kbz_b.BoostCore

class FlutterFragmentStub : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val routeKey = arguments?.getString(BoostCore.ROUTE_KEY)
        val parameter = arguments?.getString(BoostCore.ROUTE_PARAMS)

        val urlParams =
            Gson().fromJson(parameter, Map::class.java) as Map<String, *>?

        Log.d("flutter", "经过重新转化之后的参数是 $urlParams")

        if (TextUtils.isEmpty(routeKey)) {
            throw RuntimeException("routeKey can not be empty or null!!!")
        }

        val f = FlutterBoostFragment.CachedEngineFragmentBuilder(FriendFlutterFragment::class.java)
            .url(routeKey)
            .urlParams(urlParams ?: HashMap<String, Any?>())
            .build<FriendFlutterFragment>()
        childFragmentManager.beginTransaction().replace(R.id.fl_flutter_stub, f).commit()
    }

}

class FriendFlutterFragment : FlutterBoostFragment() {
    private val uniqueId: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
    }
}