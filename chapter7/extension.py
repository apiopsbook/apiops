from hypothesis import strategies as st
from schemathesis import register_string_format


register_string_format("uuid", st.uuids().map(str))
